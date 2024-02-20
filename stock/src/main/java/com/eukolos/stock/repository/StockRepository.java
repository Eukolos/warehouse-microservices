package com.eukolos.stock.repository;

import com.eukolos.stock.model.Stock;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface StockRepository extends CrudRepository<Stock, String> {
    Optional<Stock> findStockByItemId(String itemId);
}
