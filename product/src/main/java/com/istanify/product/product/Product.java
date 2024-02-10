package com.istanify.product.product;


import com.istanify.product.enumeration.BrandEnum;
import com.istanify.product.enumeration.CategoryEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private Long id;
    private String productName;
    private String productDescription;
    private CategoryEnum productCategory;
    private BrandEnum productBrand;
    private String productModel;

}
