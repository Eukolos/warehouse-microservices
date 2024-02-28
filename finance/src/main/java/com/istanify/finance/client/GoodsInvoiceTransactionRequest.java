package com.istanify.finance.client;

public record GoodsInvoiceTransactionRequest(
        String description,
        Long accountId,
        Long paymentId,
        Double amount,
        String invoiceNumber,
        Boolean type
) { }
