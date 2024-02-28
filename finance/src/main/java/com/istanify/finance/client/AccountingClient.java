package com.istanify.finance.client;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface AccountingClient {

    @PostExchange("/api/transaction")
    TransactionDto saveTransaction(@RequestBody GoodsInvoiceTransactionRequest transaction);

}
