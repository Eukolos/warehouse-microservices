package com.istanify.warehouse.service;

import com.istanify.warehouse.dto.StockItemInfoDto;
import com.istanify.warehouse.dto.WaybillInfoDto;
import com.istanify.warehouse.dto.WaybillRequest;
import com.istanify.warehouse.model.StockItem;
import com.istanify.warehouse.model.Supplier;
import com.istanify.warehouse.model.Waybill;
import com.istanify.warehouse.repository.WaybillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaybillService {
    private final WaybillRepository repository;
    private final SupplierService supplierService;
    private final StockItemService stockItemService;



    public WaybillService(WaybillRepository repository, SupplierService supplierService, StockItemService stockItemService) {
        this.repository = repository;
        this.supplierService = supplierService;
        this.stockItemService = stockItemService;
    }

    public Waybill createWaybill(WaybillRequest request) {
        Supplier supplier = supplierService.getSupplier(request.getSupplierId());
        Waybill waybill = repository.save(WaybillRequest.toWaybill(request, supplier));
        for(StockItem stockItem : waybill.getStockItems()) {
            stockItem.setWaybill(waybill);
        }

        stockItemService.saveStockItems(waybill.getStockItems());
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

}
