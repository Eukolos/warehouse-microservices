package com.istanify.warehouse.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.istanify.warehouse.model.Supplier}
 */
public class SupplierDto implements Serializable {
    private final Long id;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final long taxId;
    private final String email;

    public SupplierDto(Long id, String name, String address, String phoneNumber, long taxId, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.email = email;
    }

    public Long getId() {
        return id;
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
        SupplierDto entity = (SupplierDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.taxId, entity.taxId) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phoneNumber, taxId, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "address = " + address + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "taxId = " + taxId + ", " +
                "email = " + email + ")";
    }
}