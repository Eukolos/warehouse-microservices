package com.istanify.product.dataseed;

import com.istanify.product.enumeration.BrandEnum;
import com.istanify.product.enumeration.CategoryEnum;
import com.istanify.product.product.Product;
import com.istanify.product.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeed implements CommandLineRunner {
    private final ProductRepository repository;

    public ProductSeed(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args)  {
        if (repository.count() > 0) {
            return;
        }
        Product product1 = new Product("Brake", "fore tired brake", CategoryEnum.BRAKE, BrandEnum.BMW, "CL-200");
        Product product2 = new Product("Tire", "fore tired", CategoryEnum.BODY, BrandEnum.BMW, "CL-250");
        Product product3 = new Product("Engine", "fore tired engine", CategoryEnum.ENGINE, BrandEnum.BMW, "CL-300");
        Product product4 = new Product("Suspension", "fore tired suspension", CategoryEnum.SUSPENSION, BrandEnum.BMW, "CL-400");
        Product product5 = new Product("Transmission", "fore tired transmission", CategoryEnum.TRANSMISSION, BrandEnum.BMW, "CL-500");
        Product product6 = new Product("Brake", "fore tired brake", CategoryEnum.BRAKE, BrandEnum.TOYOTA, "CL-200");
        Product product7 = new Product("Tire", "fore tired", CategoryEnum.BODY, BrandEnum.TOYOTA, "CL-250");
        Product product8 = new Product("Engine", "fore tired engine", CategoryEnum.ENGINE, BrandEnum.TOYOTA, "CL-300");
        Product product9 = new Product("Suspension", "fore tired suspension", CategoryEnum.SUSPENSION, BrandEnum.TOYOTA, "CL-400");
        Product product10 = new Product("Transmission", "fore tired transmission", CategoryEnum.TRANSMISSION, BrandEnum.TOYOTA, "CL-500");

        repository.saveAll(List.of(product1, product2, product3, product4, product5, product6, product7, product8, product9, product10));
    }
}
