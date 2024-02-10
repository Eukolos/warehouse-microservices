package com.istanify.warehouse.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Waybill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String waybillNumber;
    private LocalDate waybillDate;
    @ManyToOne( fetch = FetchType.EAGER)
    private Supplier supplier;
    private LocalDate arrivalDate;
    @OneToMany(mappedBy = "waybill", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<StockItem> stockItems;
}
