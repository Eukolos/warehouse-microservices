package com.istanify.accounting.service;


import com.istanify.accounting.dto.GoodsInvoiceTransactionRequest;
import com.istanify.accounting.model.Account;
import com.istanify.accounting.model.Transaction;
import com.istanify.accounting.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;
    private final AccountService accountService;

    public TransactionService(TransactionRepository repository, AccountService accountService) {
        this.repository = repository;
        this.accountService = accountService;
    }

    public List<Transaction> getTransactions() {
        return repository.findAll();
    }

    public Transaction saveTransaction(GoodsInvoiceTransactionRequest request) {

        // payment
        accountService.updateAccountBalance(request.paymentId(), request.amount() * -1);

        // product value set related account
        accountService.updateAccountBalance(request.accountId(), request.amount());

        Account account = accountService.getAccount(request.accountId());

        return repository.save(new Transaction(
                request.description(),
                account,
                request.amount(),
                LocalDate.now().toString(),
                request.invoiceNumber(),
                request.type()
        ));
    }


    public Transaction getTransaction(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
    }

}
