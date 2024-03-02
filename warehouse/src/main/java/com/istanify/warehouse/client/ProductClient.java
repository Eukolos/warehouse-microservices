package com.istanify.warehouse.client;

import com.istanify.warehouse.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "product-service",  path = "/api/v1/products")
public interface ProductClient {


    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto product);

    @GetMapping
    public List<ProductDto> getProductList();

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable String id);

    @GetMapping("/name/{name}")
    public List<ProductDto> getProductByName(@PathVariable String name);

    @GetMapping("/category/{category}")
    public List<ProductDto> getProductByCategory(@PathVariable String category);

    @GetMapping("/brand/{brand}")
    public List<ProductDto> getProductByBrand(@PathVariable String brand);

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto product);

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id);
}
