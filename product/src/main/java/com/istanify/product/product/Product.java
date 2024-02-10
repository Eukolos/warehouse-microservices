package com.istanify.product.product;


import com.istanify.product.enumeration.BrandEnum;
import com.istanify.product.enumeration.CategoryEnum;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "products")
public class Product {
    @MongoId(targetType = FieldType.STRING)
    private String id;
    private String productName;
    private String productDescription;
    private CategoryEnum productCategory;
    private BrandEnum productBrand;
    private String productModel;

    public Product() {
    }

    public Product(String productName, String productDescription, CategoryEnum productCategory, BrandEnum productBrand, String productModel) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.productModel = productModel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public CategoryEnum getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(CategoryEnum productCategory) {
        this.productCategory = productCategory;
    }

    public BrandEnum getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(BrandEnum productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }
}
