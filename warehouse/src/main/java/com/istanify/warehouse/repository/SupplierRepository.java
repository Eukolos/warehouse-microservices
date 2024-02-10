package com.istanify.warehouse.repository;

import com.istanify.warehouse.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
