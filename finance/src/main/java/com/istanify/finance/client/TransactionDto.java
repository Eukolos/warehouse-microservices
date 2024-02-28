package com.istanify.finance.client;

public record TransactionDto(Long id, String description, String invoiceNumber, AccountDto account, Double amount, String date, String status, Boolean type) {}