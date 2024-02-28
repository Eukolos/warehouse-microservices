package com.istanify.finance.service;

import com.istanify.finance.client.AccountingClient;
import com.istanify.finance.client.GoodsInvoiceTransactionRequest;
import com.istanify.finance.model.Invoice;
import com.istanify.finance.repository.InvoiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.DoubleConsumer;

@Service
public class InvoiceService {
    private final InvoiceRepository repository;
    private final WaybillStatusService waybillStatusService;
    private final AccountingClient accountingClient;


    public InvoiceService(InvoiceRepository repository, WaybillStatusService waybillStatusService, AccountingClient accountingClient) {
        this.repository = repository;
        this.waybillStatusService = waybillStatusService;
        this.accountingClient = accountingClient;
    }


    public Invoice saveInvoice(Invoice invoice) {
        waybillStatusService.setWaybillInvoiced(invoice.getWaybillNumber());

        accountingClient.saveTransaction(
                new GoodsInvoiceTransactionRequest(
                        "invoice for goods",
                        15L,
                        1L,
                        Double.valueOf(invoice.getInvoiceAmount()),
                        invoice.getInvoiceNumber(),
                        false
                )
        );
        return repository.save(invoice);
    }

    public List<Invoice> getInvoices() {
        return repository.findAll();
    }

    public void deleteInvoice(Long id) {
        Invoice invoice = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
        waybillStatusService.setWaybillNotInvoiced(invoice.getWaybillNumber());
        repository.deleteById(invoice.getId());
    }

    public Invoice getInvoice(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
    }
}
