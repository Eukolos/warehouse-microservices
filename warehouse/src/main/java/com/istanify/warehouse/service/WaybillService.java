package com.istanify.warehouse.service;

import com.istanify.warehouse.dto.WaybillDto;
import com.istanify.warehouse.dto.WaybillRequest;
import com.istanify.warehouse.model.Waybill;
import com.istanify.warehouse.repository.WaybillRepository;
import org.springframework.stereotype.Service;

@Service
public class WaybillService {
    private final WaybillRepository repository;


    public WaybillService(WaybillRepository repository) {
        this.repository = repository;
    }

    public WaybillDto createWaybill(WaybillRequest waybill, Long supplierId) {

        return repository.save(waybill);
    }
}
