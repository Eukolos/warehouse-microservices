package com.istanify.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private long taxId;
    private String email;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<Waybill> waybill;


    public Supplier() {
    }

    public Supplier(Long id, String name, String address, String phoneNumber, long taxId, String email, List<Waybill> waybill) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.email = email;
        this.waybill = waybill;
    }
    public Supplier(String name, String address, String phoneNumber, long taxId, String email, List<Waybill> waybill) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.email = email;
        this.waybill = waybill;
    }

    public Supplier(String name, String address, String phoneNumber, long taxId, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getTaxId() {
        return taxId;
    }

    public void setTaxId(long taxId) {
        this.taxId = taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Waybill> getWaybill() {
        return waybill;
    }

    public void setWaybill(List<Waybill> waybill) {
        this.waybill = waybill;
    }
}
