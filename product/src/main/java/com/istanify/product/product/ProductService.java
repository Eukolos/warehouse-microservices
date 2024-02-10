package com.istanify.product.product;

import com.istanify.product.enumeration.BrandEnum;
import com.istanify.product.enumeration.CategoryEnum;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductCategory(product.getProductCategory());
        existingProduct.setProductBrand(product.getProductBrand());
        existingProduct.setProductModel(product.getProductModel());
        return productRepository.save(existingProduct);
    }

    public Product getProduct(String id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findByProductName(name).orElseThrow(() -> new EntityNotFoundException("Product not found with name: " + name));
    }

    public List<Product> getProductByCategory(CategoryEnum category) {
        return productRepository.findByProductCategory(category).orElseThrow(() -> new EntityNotFoundException("Product not found with category: " + category));
    }

    public List<Product> getProductByBrand(BrandEnum brand) {
        return productRepository.findByProductBrand(brand).orElseThrow(() -> new EntityNotFoundException("Product not found with brand: " + brand));
    }

    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
