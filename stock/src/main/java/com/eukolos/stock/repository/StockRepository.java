package com.eukolos.stock.repository;

import com.eukolos.stock.model.Stock;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends CouchbaseRepository<Stock, Long>{
    Optional<Stock> findByItemId(String itemId);
}
