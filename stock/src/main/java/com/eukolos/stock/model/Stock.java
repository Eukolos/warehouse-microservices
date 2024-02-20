package com.eukolos.stock.model;

import com.eukolos.stock.consumers.model.WaybillRecordEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import java.util.List;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Document
public class Stock {
    @Id
    @GeneratedValue(strategy = UNIQUE)
    private Long id;
    @Field
    private String itemId;
    @Field
    private Long quantity;
    @Field
    private List<String> waybillIds;

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
