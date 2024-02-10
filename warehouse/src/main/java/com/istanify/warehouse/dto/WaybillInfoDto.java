package com.istanify.warehouse.dto;

import com.istanify.warehouse.model.Supplier;
import com.istanify.warehouse.model.Waybill;

import java.util.ArrayList;
import java.util.List;

public class WaybillInfoDto {
    private final Long id;
    private final String waybillNumber;
    private final String waybillDate;
    private final String arrivalDate;
    private final Supplier supplier;
    private final List<StockItemInfoDto> stockItems;

    public WaybillInfoDto(Long id, String waybillNumber, String waybillDate, String arrivalDate, Supplier supplier, List<StockItemInfoDto> stockItems) {
        this.id = id;
        this.waybillNumber = waybillNumber;
        this.waybillDate = waybillDate;
        this.arrivalDate = arrivalDate;
        this.supplier = supplier;
        this.stockItems = stockItems;
    }

    public Long getId() {
        return id;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public String getWaybillDate() {
        return waybillDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }
    public List<StockItemInfoDto> getStockItems() {
        return stockItems;
    }

    public static WaybillInfoDto converter(Waybill waybill, List<StockItemInfoDto> stockItems) {
        return new WaybillInfoDto(waybill.getId(), waybill.getWaybillNumber(), waybill.getWaybillDate().toString(), waybill.getArrivalDate().toString(), waybill.getSupplier(), stockItems);
    }

    public static List<WaybillInfoDto> listConverter(List<Waybill> waybills, List<List<StockItemInfoDto>> stockItems) {
        List<WaybillInfoDto> waybillInfoDtos = new ArrayList<>();
        for (int i = 0; i < waybills.size(); i++) {
            waybillInfoDtos.add(converter(waybills.get(i), stockItems.get(i)));
        }
        return waybillInfoDtos;
    }


}
