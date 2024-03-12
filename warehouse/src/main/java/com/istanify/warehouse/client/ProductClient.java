package com.istanify.warehouse.client;

import com.istanify.warehouse.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "product-service", path = "/api/v1/products")
public interface ProductClient {

    @PostMapping
    ProductDto createProduct(@RequestBody ProductDto product);

    @GetMapping
    List<ProductDto> getProductList();

    @GetMapping("/{id}")
    ProductDto getProduct(@PathVariable String id);

    @GetMapping("/name/{name}")
    List<ProductDto> getProductByName(@PathVariable String name);

    @GetMapping("/category/{category}")
    List<ProductDto> getProductByCategory(@PathVariable String category);

    @GetMapping("/brand/{brand}")
    List<ProductDto> getProductByBrand(@PathVariable String brand);

    @PutMapping("/{id}")
    ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto product);

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Long id);
}
