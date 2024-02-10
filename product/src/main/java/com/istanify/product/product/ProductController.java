package com.istanify.product.product;

import com.istanify.product.enumeration.BrandEnum;
import com.istanify.product.enumeration.CategoryEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> getProductList() {
        return service.getProductList();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return service.getProduct(id);
    }
    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }
    @GetMapping("/category/{category}")
    public List<Product> getProductByCategory(@PathVariable CategoryEnum category) {
        return service.getProductByCategory(category);
    }
    @GetMapping("/brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable BrandEnum brand) {
        return service.getProductByBrand(brand);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
    }
}
