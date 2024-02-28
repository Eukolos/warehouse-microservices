package com.istanify.accounting.service;

import com.istanify.accounting.model.Account;
import com.istanify.accounting.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account getAccount(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account not found"));
    }
    public Account updateAccountBalance(Long id, Double amount) {
        Account existingAccount = getAccount(id);
        Double currentBalance = existingAccount.getBalance();
        existingAccount.setBalance(currentBalance + amount);

        return repository.save(existingAccount);
    }

}
