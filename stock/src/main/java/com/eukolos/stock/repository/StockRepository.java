package com.eukolos.stock.repository;

import com.eukolos.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, String> {
    Optional<Stock> findFirstStockByItemId(String itemId);
}
