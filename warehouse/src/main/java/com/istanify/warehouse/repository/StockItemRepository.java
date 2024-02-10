package com.istanify.warehouse.repository;

import com.istanify.warehouse.model.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    Optional<List<StockItem>> findByWaybillId(Long waybillId);
}
