package com.istanify.warehouse.dataseed;

import com.istanify.warehouse.model.Supplier;
import com.istanify.warehouse.repository.SupplierRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public class SupplierSeed implements CommandLineRunner {
    private final SupplierRepository repository;

    public SupplierSeed(SupplierRepository repository) {
        this.repository = repository;
    }
    @Override
    public void run(String... args)  {
        if (repository.count() > 0) {
            return;
        }

    }
}
