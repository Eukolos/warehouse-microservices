package com.istanify.warehouse.repository;

import com.istanify.warehouse.model.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaybillRepository extends JpaRepository<Waybill, Long> {
}
