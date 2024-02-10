package com.istanify.warehouse.repository;

import com.istanify.warehouse.model.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {
}
