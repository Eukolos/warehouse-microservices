package com.istanify.warehouse.service;

import com.istanify.warehouse.client.ProductClient;
import com.istanify.warehouse.dto.ProductDto;
import com.istanify.warehouse.dto.StockItemInfoDto;
import com.istanify.warehouse.model.StockItem;
import com.istanify.warehouse.repository.StockItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockItemService {
    private final ProductClient productClient;
    private final StockItemRepository repository;


    public StockItemService(ProductClient productClient, StockItemRepository repository ) {
        this.productClient = productClient;
        this.repository = repository;
    }

    public List<StockItem> getAllStockItems() {
        return repository.findAll();
    }
    public StockItem getStockItem(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<StockItemInfoDto> getStockItemInfo(Long waybillId) {
        List<StockItem> stockItemList = repository.findByWaybillId(waybillId).orElseThrow(() -> new EntityNotFoundException("StockItem not found with waybillId: " + waybillId));
        List<StockItemInfoDto> stockItemInfoDtoList = new ArrayList<>();
        List<ProductDto> productDtoList = productClient.getProductList();
        System.out.println("productDtoList: " + productDtoList);
        for (StockItem stockItem : stockItemList) {
            stockItemInfoDtoList.add(StockItemInfoDto.converter(stockItem, productDtoList.stream().filter(productDto -> productDto.id().equals(stockItem.getProductId())).findFirst().orElse(null)));
        }
        return stockItemInfoDtoList;
    }

    public List<StockItem> saveStockItems(List<StockItem> stockItems) {
        return repository.saveAll(stockItems);
    }

}
