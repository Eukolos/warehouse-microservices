package com.istanify.warehouse.dto;

import com.istanify.warehouse.model.Supplier;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Supplier}
 */
public class SupplierCreateRequest implements Serializable {
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final long taxId;
    private final String email;

    public SupplierCreateRequest(String name, String address, String phoneNumber, long taxId, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getTaxId() {
        return taxId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierCreateRequest entity = (SupplierCreateRequest) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.taxId, entity.taxId) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, taxId, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "address = " + address + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "taxId = " + taxId + ", " +
                "email = " + email + ")";
    }
}