package com.istanify.warehouse.dto;

public record ProductDto(
        String id,
        String productName,
        String productDescription,
        String productCategory,
        String productBrand,
        String productModel
) {
}
