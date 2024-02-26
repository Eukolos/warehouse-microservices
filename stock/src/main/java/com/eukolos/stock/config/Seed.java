package com.eukolos.stock.config;

import com.eukolos.stock.model.Stock;
import com.eukolos.stock.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.eukolos.stock.service.StockService;

import java.util.List;
@Slf4j
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
//        repository.save(new Stock("sads", 1L, List.of("sads")));
//
//        service.save(new Stock("sads", 1L, List.of("sads")));


    }
}
