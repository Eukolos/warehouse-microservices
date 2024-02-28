package com.istanify.accounting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double balance;
    private Integer accountTypeCode;

    @JsonIgnore
    @OneToMany(mappedBy = "account", targetEntity = Transaction.class, orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(String name, String description, Double balance, Integer accountTypeCode) {
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.accountTypeCode = accountTypeCode;
    }

    public Account(String name, String description, Double balance, Integer accountTypeCode, List<Transaction> transactions) {
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.accountTypeCode = accountTypeCode;
        this.transactions = transactions;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(Integer accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.setAccount(null);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", balance=" + balance +
                ", accountTypeCode=" + accountTypeCode +
                ", transactions=" + transactions +
                '}';
    }
}
