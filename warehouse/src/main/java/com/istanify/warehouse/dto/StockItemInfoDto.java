package com.istanify.warehouse.dto;

import com.istanify.warehouse.model.StockItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.istanify.warehouse.model.StockItem}
 */
public class StockItemInfoDto implements Serializable {
    private final Long id;
    private final BigDecimal cost;
    private final BigDecimal price;
    private final LocalDate arrivalTime;
    private final long quantity;
    private final String shelfLocation;
    private final ProductDto productInfo;

    public StockItemInfoDto(Long id, BigDecimal cost, BigDecimal price, LocalDate arrivalTime, long quantity, String shelfLocation, ProductDto productInfo) {
        this.id = id;
        this.cost = cost;
        this.price = price;
        this.arrivalTime = arrivalTime;
        this.quantity = quantity;
        this.shelfLocation = shelfLocation;
        this.productInfo = productInfo;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public ProductDto getProductInfo() {
        return productInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItemInfoDto entity = (StockItemInfoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cost, entity.cost) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.arrivalTime, entity.arrivalTime) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.shelfLocation, entity.shelfLocation) &&
                Objects.equals(this.productInfo, entity.productInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, price, arrivalTime, quantity, shelfLocation, productInfo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cost = " + cost + ", " +
                "price = " + price + ", " +
                "arrivalTime = " + arrivalTime + ", " +
                "quantity = " + quantity + ", " +
                "shelfLocation = " + shelfLocation + ", " +
                "productId = " + productInfo + ")";
    }

    public static StockItemInfoDto converter(StockItem stockItem, ProductDto productInfo) {
        return new StockItemInfoDto(stockItem.getId(), stockItem.getCost(), stockItem.getPrice(), stockItem.getArrivalTime(), stockItem.getQuantity(), stockItem.getShelfLocation(), productInfo);
    }
}
