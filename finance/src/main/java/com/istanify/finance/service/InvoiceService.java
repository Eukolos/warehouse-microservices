package com.istanify.finance.service;

import com.istanify.finance.model.Invoice;
import com.istanify.finance.repository.InvoiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceRepository repository;
    private final WaybillStatusService waybillStatusService;


    public InvoiceService(InvoiceRepository repository, WaybillStatusService waybillStatusService) {
        this.repository = repository;
        this.waybillStatusService = waybillStatusService;
    }


    public Invoice saveInvoice(Invoice invoice) {
        waybillStatusService.setWaybillInvoiced(invoice.getWaybillNumber());
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
