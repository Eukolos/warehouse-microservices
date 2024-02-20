package com.istanify.warehouse.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Waybill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String waybillNumber;
    private LocalDate waybillDate;
    @ManyToOne( fetch = FetchType.EAGER)
    private Supplier supplier;
    private LocalDate arrivalDate;
    @OneToMany(mappedBy = "waybill", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockItem> stockItems;

    public Waybill() {
    }

    public Waybill(String waybillNumber, LocalDate waybillDate, Supplier supplier, LocalDate arrivalDate, List<StockItem> stockItems) {
        this.waybillNumber = waybillNumber;
        this.waybillDate = waybillDate;
        this.supplier = supplier;
        this.arrivalDate = arrivalDate;
        this.stockItems = stockItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public LocalDate getWaybillDate() {
        return waybillDate;
    }

    public void setWaybillDate(LocalDate waybillDate) {
        this.waybillDate = waybillDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }
}
