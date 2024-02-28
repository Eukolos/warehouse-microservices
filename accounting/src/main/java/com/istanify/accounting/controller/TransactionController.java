package com.istanify.accounting.controller;


import com.istanify.accounting.dto.GoodsInvoiceTransactionRequest;
import com.istanify.accounting.model.Transaction;
import com.istanify.accounting.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return service.getTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return service.getTransaction(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction saveTransaction(@RequestBody GoodsInvoiceTransactionRequest transaction) {
        return service.saveTransaction(transaction);
    }


}
