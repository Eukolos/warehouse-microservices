package com.istanify.accounting.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String description;

    private String invoiceNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;
    private Double amount;
    private String date;
    private String status;
    private Boolean type; // true for income, false for expense so dept and receivable can be calculated


    public Transaction() {
    }

    public Transaction(String description, Account account, Double amount, String date, String status, Boolean type) {
        this.description = description;
        this.account = account;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", account=" + account +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", type=" + type +
                '}';
    }
}
