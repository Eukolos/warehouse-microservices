package com.istanify.warehouse.service;

import com.istanify.warehouse.configuration.kafka.producer.KafkaProducer;
import com.istanify.warehouse.configuration.kafka.properties.WaybillRecordTopicProperties;
import com.istanify.warehouse.dto.StockItemInfoDto;
import com.istanify.warehouse.dto.WaybillInfoDto;
import com.istanify.warehouse.dto.WaybillRequest;
import com.istanify.warehouse.model.StockItem;
import com.istanify.warehouse.model.Supplier;
import com.istanify.warehouse.model.Waybill;
import com.istanify.warehouse.model.WaybillRecordEvent;
import com.istanify.warehouse.repository.WaybillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.KEY;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class WaybillService {
    private final WaybillRepository repository;
    private final SupplierService supplierService;
    private final StockItemService stockItemService;
    private final KafkaProducer kafkaProducer;
    private final WaybillRecordTopicProperties waybillRecordTopicProperties;



    public WaybillService(WaybillRepository repository, SupplierService supplierService, StockItemService stockItemService, KafkaProducer kafkaProducer, WaybillRecordTopicProperties waybillRecordTopicProperties) {
        this.repository = repository;
        this.supplierService = supplierService;
        this.stockItemService = stockItemService;

        this.kafkaProducer = kafkaProducer;
        this.waybillRecordTopicProperties = waybillRecordTopicProperties;
    }

    public Waybill createWaybill(WaybillRequest request) {
        Supplier supplier = supplierService.getSupplier(request.getSupplierId());
        Waybill waybill = repository.save(WaybillRequest.toWaybill(request, supplier));
        for(StockItem stockItem : waybill.getStockItems()) {
            stockItem.setWaybill(waybill);
        }
        stockItemService.saveStockItems(waybill.getStockItems());
        String waybillNumber = waybill.getWaybillNumber();
        kafkaSendMessage(waybill.getStockItems(), waybillNumber);
        return waybill;
    }

    public Waybill getWaybill(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Waybill not found with id: " + id));
    }
    public WaybillInfoDto getWaybillInfo(Long id) {
        Waybill waybill = getWaybill(id);
        List<StockItemInfoDto> stockItemInfoDto = stockItemService.getStockItemInfo(id);
        return WaybillInfoDto.converter(waybill, stockItemInfoDto);

    }

    public List<Waybill> getAllWaybills() {
        return repository.findAll();
    }
    public void deleteWaybill(Long id) {
        repository.deleteById(id);
    }
    private void kafkaSendMessage(List<StockItem> stockItems, String waybillNumber) {
        for (StockItem stockItem : stockItems) {
            WaybillRecordEvent waybillRecordEvent = new WaybillRecordEvent(stockItem.getProductId(), stockItem.getQuantity(), waybillNumber);
            Map<String, Object> headers = new HashMap<>();
            headers.put(TOPIC, waybillRecordTopicProperties.getTopicName());
            headers.put(KEY, UUID.randomUUID().toString());
            kafkaProducer.sendMessage(new GenericMessage<>(waybillRecordEvent, headers));

        }
    }

}
