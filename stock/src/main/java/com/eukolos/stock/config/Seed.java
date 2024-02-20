package com.eukolos.stock.config;

import com.eukolos.stock.model.Stock;
import com.eukolos.stock.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.eukolos.stock.service.StockService;

import java.util.List;

@Component
public class Seed implements CommandLineRunner {
    private final StockService service;
    private final StockRepository repository;

    public Seed(StockService service, StockRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        //service.save(new Stock("sads", 1L, List.of("sads")));
        repository.findStockByItemId("sads").ifPresent(stock -> {
            stock.setQuantity(stock.getQuantity() + 1);
            stock.getWaybillIds().add("sads");
            repository.save(stock);
        });
        repository.save(new Stock("sads", 1L, List.of("sads")));
    }
}
