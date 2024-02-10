package com.istanify.warehouse.service;

import com.istanify.warehouse.dto.SupplierCreateRequest;
import com.istanify.warehouse.model.Supplier;
import com.istanify.warehouse.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier createSupplier(SupplierCreateRequest supplier) {
        Supplier newSupplier = new Supplier(supplier.getName(), supplier.getAddress(), supplier.getPhoneNumber(), supplier.getTaxId(), supplier.getEmail());
        return repository.save(newSupplier);
    }
    public Supplier getSupplier(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Supplier not found with id: " + id));
    }

    public void deleteSupplier(Long id) {
        repository.deleteById(id);
    }
    public Supplier updateSupplier(Long id, SupplierCreateRequest supplier) {
        Supplier existingSupplier = getSupplier(id);
        existingSupplier.setName(supplier.getName());
        existingSupplier.setAddress(supplier.getAddress());
        existingSupplier.setPhoneNumber(supplier.getPhoneNumber());
        existingSupplier.setTaxId(supplier.getTaxId());
        existingSupplier.setEmail(supplier.getEmail());
        return repository.save(existingSupplier);
    }
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }
}
