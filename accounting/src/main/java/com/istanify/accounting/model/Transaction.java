package com.istanify.accounting.model;

public class Transaction {

    private String id;
    private String description;
    private Account account;
    private Double amount;
    private String date;
    private String currency;
    private String status;
    private Boolean type; // true for income, false for expense so dept and receivable can be calculated

}
