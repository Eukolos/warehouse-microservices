package com.eukolos.stock.model;

import com.eukolos.stock.consumers.model.WaybillRecordEvent;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String itemId;
    private Long quantity;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> waybillIds=new ArrayList<>();

    public static Stock EventToNotificationEntity(WaybillRecordEvent event) {
        return new Stock(event.getItemId(), event.getQuantity(), List.of(event.getWaybillId()));
    }

    public Stock() {
    }

    public Stock(String itemId, Long quantity, List<String> waybillIds) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.waybillIds = waybillIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getWaybillIds() {
        return waybillIds;
    }

    public void setWaybillIds(List<String> waybillIds) {
        this.waybillIds = waybillIds;
    }
}
