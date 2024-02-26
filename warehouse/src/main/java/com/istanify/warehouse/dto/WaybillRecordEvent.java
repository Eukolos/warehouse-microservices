package com.istanify.warehouse.dto;


public class WaybillRecordEvent {
    private String itemId;
    private Long quantity;
    private String waybillId;

    public WaybillRecordEvent() {
    }

    public WaybillRecordEvent(String itemId, Long quantity, String waybillId) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.waybillId = waybillId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(String waybillId) {
        this.waybillId = waybillId;
    }
}
