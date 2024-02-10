package com.istanify.warehouse.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.istanify.warehouse.model.Waybill}
 */
public class WaybillRequest implements Serializable {
    private final String waybillNumber;
    private final LocalDate waybillDate;
    private final LocalDate arrivalDate;
    private final List<StockItemRequest> stockItems;

    public WaybillRequest(String waybillNumber, LocalDate waybillDate, LocalDate arrivalDate, List<StockItemRequest> stockItems) {
        this.waybillNumber = waybillNumber;
        this.waybillDate = waybillDate;
        this.arrivalDate = arrivalDate;
        this.stockItems = stockItems;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public LocalDate getWaybillDate() {
        return waybillDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public List<StockItemRequest> getStockItems() {
        return stockItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaybillRequest entity = (WaybillRequest) o;
        return Objects.equals(this.waybillNumber, entity.waybillNumber) &&
                Objects.equals(this.waybillDate, entity.waybillDate) &&
                Objects.equals(this.arrivalDate, entity.arrivalDate) &&
                Objects.equals(this.stockItems, entity.stockItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(waybillNumber, waybillDate, arrivalDate, stockItems);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "waybillNumber = " + waybillNumber + ", " +
                "waybillDate = " + waybillDate + ", " +
                "arrivalDate = " + arrivalDate + ", " +
                "stockItems = " + stockItems + ")";
    }
}