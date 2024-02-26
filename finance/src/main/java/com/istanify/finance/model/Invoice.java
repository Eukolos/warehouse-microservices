package com.istanify.finance.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;
    private String invoiceNumber;
    private String invoiceSupplier;
    private String waybillNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;
    private String invoiceAmount;
    private Currency invoiceCurrency;
    private String invoiceType;
    private String invoiceStatus;
    private String invoicePaymentDate;
    private String invoicePaymentStatus;
    private String invoicePaymentAmount;
    private String invoicePaymentCurrency;


    public Invoice() {
    }

    public Invoice(String invoiceNumber, String invoiceSupplier, String waybillNumber, LocalDate invoiceDate, String invoiceAmount, Currency invoiceCurrency) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceSupplier = invoiceSupplier;
        this.waybillNumber = waybillNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
        this.invoiceCurrency = invoiceCurrency;
    }

    public Invoice(String invoiceNumber, String invoiceSupplier, String waybillNumber, LocalDate invoiceDate, String invoiceAmount, Currency invoiceCurrency, String invoiceType, String invoiceStatus, String invoicePaymentDate, String invoicePaymentStatus, String invoicePaymentAmount, String invoicePaymentCurrency) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceSupplier = invoiceSupplier;
        this.waybillNumber = waybillNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
        this.invoiceCurrency = invoiceCurrency;
        this.invoiceType = invoiceType;
        this.invoiceStatus = invoiceStatus;
        this.invoicePaymentDate = invoicePaymentDate;
        this.invoicePaymentStatus = invoicePaymentStatus;
        this.invoicePaymentAmount = invoicePaymentAmount;
        this.invoicePaymentCurrency = invoicePaymentCurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceSupplier() {
        return invoiceSupplier;
    }

    public void setInvoiceSupplier(String invoiceSupplier) {
        this.invoiceSupplier = invoiceSupplier;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Currency getInvoiceCurrency() {
        return invoiceCurrency;
    }

    public void setInvoiceCurrency(Currency invoiceCurrency) {
        this.invoiceCurrency = invoiceCurrency;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getInvoicePaymentDate() {
        return invoicePaymentDate;
    }

    public void setInvoicePaymentDate(String invoicePaymentDate) {
        this.invoicePaymentDate = invoicePaymentDate;
    }

    public String getInvoicePaymentStatus() {
        return invoicePaymentStatus;
    }

    public void setInvoicePaymentStatus(String invoicePaymentStatus) {
        this.invoicePaymentStatus = invoicePaymentStatus;
    }

    public String getInvoicePaymentAmount() {
        return invoicePaymentAmount;
    }

    public void setInvoicePaymentAmount(String invoicePaymentAmount) {
        this.invoicePaymentAmount = invoicePaymentAmount;
    }

    public String getInvoicePaymentCurrency() {
        return invoicePaymentCurrency;
    }

    public void setInvoicePaymentCurrency(String invoicePaymentCurrency) {
        this.invoicePaymentCurrency = invoicePaymentCurrency;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceSupplier='" + invoiceSupplier + '\'' +
                ", waybillNumber='" + waybillNumber + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", invoiceAmount='" + invoiceAmount + '\'' +
                ", invoiceCurrency=" + invoiceCurrency +
                ", invoiceType='" + invoiceType + '\'' +
                ", invoiceStatus='" + invoiceStatus + '\'' +
                ", invoicePaymentDate='" + invoicePaymentDate + '\'' +
                ", invoicePaymentStatus='" + invoicePaymentStatus + '\'' +
                ", invoicePaymentAmount='" + invoicePaymentAmount + '\'' +
                ", invoicePaymentCurrency='" + invoicePaymentCurrency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) && Objects.equals(invoiceNumber, invoice.invoiceNumber) && Objects.equals(invoiceSupplier, invoice.invoiceSupplier) && Objects.equals(waybillNumber, invoice.waybillNumber) && Objects.equals(invoiceDate, invoice.invoiceDate) && Objects.equals(invoiceAmount, invoice.invoiceAmount) && invoiceCurrency == invoice.invoiceCurrency && Objects.equals(invoiceType, invoice.invoiceType) && Objects.equals(invoiceStatus, invoice.invoiceStatus) && Objects.equals(invoicePaymentDate, invoice.invoicePaymentDate) && Objects.equals(invoicePaymentStatus, invoice.invoicePaymentStatus) && Objects.equals(invoicePaymentAmount, invoice.invoicePaymentAmount) && Objects.equals(invoicePaymentCurrency, invoice.invoicePaymentCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceNumber, invoiceSupplier, waybillNumber, invoiceDate, invoiceAmount, invoiceCurrency, invoiceType, invoiceStatus, invoicePaymentDate, invoicePaymentStatus, invoicePaymentAmount, invoicePaymentCurrency);
    }
}
