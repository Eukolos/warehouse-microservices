package com.eukolos.stock.service;

import com.eukolos.stock.model.Stock;
import com.eukolos.stock.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StockService {
    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public void save(Stock stock) {
        Optional<Stock> existingStock = repository.findFirstStockByItemId(stock.getItemId());
        if (existingStock.isPresent()) {
            Stock stockToUpdate = existingStock.get();
            stockToUpdate.setQuantity(stockToUpdate.getQuantity() + stock.getQuantity());
            stockToUpdate.getWaybillIds().add(stock.getWaybillIds().get(0));
            repository.save(stockToUpdate);
            log.warn("Stock updated" + stockToUpdate.toString());
            return;
        }
        log.warn("Stock saved" + stock.toString());
        repository.save(stock);
    }
}
