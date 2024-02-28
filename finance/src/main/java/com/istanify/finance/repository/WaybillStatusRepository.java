package com.istanify.finance.repository;

import com.istanify.finance.model.WaybillStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WaybillStatusRepository extends JpaRepository<WaybillStatus, Long> {
    List<WaybillStatus> findWaybillStatusByIsInvoiced(boolean isInvoiced);
    Optional<WaybillStatus> findByWaybillNumber(String waybillNumber);
}
