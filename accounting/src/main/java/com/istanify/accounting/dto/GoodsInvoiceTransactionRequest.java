package com.istanify.accounting.dto;

public record GoodsInvoiceTransactionRequest(
        String description,
        Long accountId,
        Long paymentId,
        Double amount,
        String invoiceNumber,
        Boolean type
) { }
