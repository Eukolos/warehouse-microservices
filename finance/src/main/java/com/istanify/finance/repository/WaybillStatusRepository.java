package com.istanify.finance.repository;

import com.istanify.finance.model.WaybillStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaybillStatusRepository extends JpaRepository<WaybillStatus, Long> {
}
