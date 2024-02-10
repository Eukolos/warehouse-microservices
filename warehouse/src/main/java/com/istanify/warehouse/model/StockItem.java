package com.istanify.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal cost;
    private BigDecimal price;
    private LocalDate arrivalTime;
    private long quantity;
    private String shelfLocation;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Waybill waybill;
    private String productId;

    public StockItem() {
    }

    public StockItem(Long id, BigDecimal cost, BigDecimal price, LocalDate arrivalTime, long quantity, String shelfLocation, Waybill waybill, String productId) {
        this.id = id;
        this.cost = cost;
        this.price = price;
        this.arrivalTime = arrivalTime;
        this.quantity = quantity;
        this.shelfLocation = shelfLocation;
        this.waybill = waybill;
        this.productId = productId;
    }

    public StockItem(BigDecimal cost, BigDecimal price, LocalDate arrivalTime, long quantity, String shelfLocation, String productId) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public Waybill getWaybill() {
        return waybill;
    }
    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
