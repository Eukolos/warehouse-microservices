package com.istanify.product.product;

import com.istanify.product.enumeration.BrandEnum;
import com.istanify.product.enumeration.CategoryEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findById(String id);
    Optional<List<Product>> findByProductName(String name);
    Optional<List<Product>> findByProductCategory(CategoryEnum category);
    Optional<List<Product>> findByProductBrand(BrandEnum brand);
}
