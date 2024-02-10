package com.istanify.product.product;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Long> {
    Optional<List<Product>> findByProductName(String name);
    Optional<List<Product>> findByProductCategory(String category);
    Optional<List<Product>> findByProductBrand(String brand);
}
