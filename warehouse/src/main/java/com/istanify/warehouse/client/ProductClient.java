package com.istanify.warehouse.client;

import com.istanify.warehouse.dto.ProductDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;

import java.util.List;

public interface ProductClient {


    @PostExchange
    public ProductDto createProduct(@RequestBody ProductDto product);

    @GetExchange
    public List<ProductDto> getProductList();

    @GetExchange("/{id}")
    public ProductDto getProduct(@PathVariable Long id);

    @GetExchange("/name/{name}")
    public List<ProductDto> getProductByName(@PathVariable String name);

    @GetExchange("/category/{category}")
    public List<ProductDto> getProductByCategory(@PathVariable String category);

    @GetExchange("/brand/{brand}")
    public List<ProductDto> getProductByBrand(@PathVariable String brand);

    @PutExchange("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto product);

    @DeleteExchange("/{id}")
    public void deleteProduct(@PathVariable Long id);
}
