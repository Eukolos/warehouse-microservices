package com.eukolos.stock.service;

import com.eukolos.stock.model.Stock;
import com.eukolos.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public void save(Stock stock) {
        Optional<Stock> existingStock = repository.findStockByItemId(stock.getItemId());
//        if (existingStock.isPresent()) {
//            Stock stockToUpdate = existingStock.get();
//            stockToUpdate.setQuantity(stockToUpdate.getQuantity() + stock.getQuantity());
//            stockToUpdate.getWaybillIds().add(stock.getWaybillIds().get(0));
//            repository.save(stockToUpdate);
//            return;
//        }
//        repository.save(stock);
    }
}
