package com.istanify.warehouse.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.istanify.warehouse.model.StockItem}
 */
public class StockItemDto implements Serializable {
    private final Long id;
    private final BigDecimal cost;
    private final BigDecimal price;
    private final LocalDate arrivalTime;
    private final long quantity;
    private final String shelfLocation;
    private final String productId;

    public StockItemDto(Long id, BigDecimal cost, BigDecimal price, LocalDate arrivalTime, long quantity, String shelfLocation, String productId) {
        this.id = id;
        this.cost = cost;
        this.price = price;
        this.arrivalTime = arrivalTime;
        this.quantity = quantity;
        this.shelfLocation = shelfLocation;
        this.productId = productId;
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

    public String getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItemDto entity = (StockItemDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cost, entity.cost) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.arrivalTime, entity.arrivalTime) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.shelfLocation, entity.shelfLocation) &&
                Objects.equals(this.productId, entity.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, price, arrivalTime, quantity, shelfLocation, productId);
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
                "productId = " + productId + ")";
    }
}