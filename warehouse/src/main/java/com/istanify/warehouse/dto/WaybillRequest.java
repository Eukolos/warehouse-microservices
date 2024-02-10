package com.istanify.warehouse.dto;

import com.istanify.warehouse.model.Supplier;
import com.istanify.warehouse.model.Waybill;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class WaybillRequest  {
    private  String waybillNumber;
    private  LocalDate waybillDate;
    private  LocalDate arrivalDate;
    private  List<StockItemRequest> stockItems;
    private  Long supplierId;

    public WaybillRequest(String waybillNumber, LocalDate waybillDate, LocalDate arrivalDate, List<StockItemRequest> stockItems, Long supplierId) {
        this.waybillNumber = waybillNumber;
        this.waybillDate = waybillDate;
        this.arrivalDate = arrivalDate;
        this.stockItems = stockItems;
        this.supplierId = supplierId;
    }

    public WaybillRequest() {
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

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public List<StockItemRequest> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItemRequest> stockItems) {
        this.stockItems = stockItems;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaybillRequest entity = (WaybillRequest) o;
        return Objects.equals(this.waybillNumber, entity.waybillNumber) &&
                Objects.equals(this.waybillDate, entity.waybillDate) &&
                Objects.equals(this.arrivalDate, entity.arrivalDate) &&
                Objects.equals(this.supplierId, entity.supplierId) &&
                Objects.equals(this.stockItems, entity.stockItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(waybillNumber, waybillDate, arrivalDate, stockItems, supplierId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "waybillNumber = " + waybillNumber + ", " +
                "waybillDate = " + waybillDate + ", " +
                "arrivalDate = " + arrivalDate + ", " +
                "supplierId = " + supplierId + ", " +
                "stockItems = " + stockItems + ")";
    }

    public static Waybill toWaybill(WaybillRequest waybillRequest, Supplier supplier) {
        return new Waybill(waybillRequest.getWaybillNumber(), waybillRequest.getWaybillDate(),supplier, waybillRequest.getArrivalDate(), StockItemRequest.toStockItemList(waybillRequest.getStockItems()));
    }
    public  static List<Waybill> toWaybillList(List<WaybillRequest> waybillRequests, Supplier supplier) {
        return waybillRequests.stream().map(waybillRequest -> toWaybill(waybillRequest, supplier)).toList();
    }

}