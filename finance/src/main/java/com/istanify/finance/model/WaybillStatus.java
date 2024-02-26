package com.istanify.finance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class WaybillStatus {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String waybillNumber;
    private Boolean isInvoiced;

    public WaybillStatus() {
    }

    public WaybillStatus(String waybillNumber, Boolean isInvoiced) {
        this.waybillNumber = waybillNumber;
        this.isInvoiced = isInvoiced;
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

    public Boolean getInvoiced() {
        return isInvoiced;
    }

    public void setInvoiced(Boolean invoiced) {
        isInvoiced = invoiced;
    }
}
