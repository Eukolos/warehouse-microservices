package com.istanify.warehouse.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.istanify.warehouse.model.Waybill}
 */
public class WaybillDto implements Serializable {
    private final Long id;
    private final String waybillNumber;
    private final LocalDate waybillDate;
    private final SupplierDto supplier;
    private final LocalDate arrivalDate;
    private final List<StockItemDto> stockItems;

    public WaybillDto(Long id, String waybillNumber, LocalDate waybillDate, SupplierDto supplier, LocalDate arrivalDate, List<StockItemDto> stockItems) {
        this.id = id;
        this.waybillNumber = waybillNumber;
        this.waybillDate = waybillDate;
        this.supplier = supplier;
        this.arrivalDate = arrivalDate;
        this.stockItems = stockItems;
    }

    public Long getId() {
        return id;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public LocalDate getWaybillDate() {
        return waybillDate;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public List<StockItemDto> getStockItems() {
        return stockItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaybillDto entity = (WaybillDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.waybillNumber, entity.waybillNumber) &&
                Objects.equals(this.waybillDate, entity.waybillDate) &&
                Objects.equals(this.supplier, entity.supplier) &&
                Objects.equals(this.arrivalDate, entity.arrivalDate) &&
                Objects.equals(this.stockItems, entity.stockItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, waybillNumber, waybillDate, supplier, arrivalDate, stockItems);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "waybillNumber = " + waybillNumber + ", " +
                "waybillDate = " + waybillDate + ", " +
                "supplier = " + supplier + ", " +
                "arrivalDate = " + arrivalDate + ", " +
                "stockItems = " + stockItems + ")";
    }
}