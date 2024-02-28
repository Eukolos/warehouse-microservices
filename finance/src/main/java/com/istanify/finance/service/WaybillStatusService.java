package com.istanify.finance.service;


import com.istanify.finance.model.WaybillStatus;
import com.istanify.finance.repository.WaybillStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaybillStatusService {
    private final WaybillStatusRepository repository;

    public WaybillStatusService(WaybillStatusRepository repository) {
        this.repository = repository;
    }

    public List<WaybillStatus> getNotInvoicedWaybills() {
        return repository.findWaybillStatusByIsInvoiced(false);
    }

    public void setWaybillInvoiced(String waybillId) {
        WaybillStatus waybillStatus = repository.findByWaybillNumber(waybillId).orElseThrow();
        if(waybillStatus.getInvoiced()) {
            throw new IllegalStateException("Waybill is already invoiced");
        }
        waybillStatus.setInvoiced(true);
        repository.save(waybillStatus);
    }

    public void setWaybillNotInvoiced(String waybillId) {
        WaybillStatus waybillStatus = repository.findByWaybillNumber(waybillId).orElseThrow();
        if(!waybillStatus.getInvoiced()) {
            throw new IllegalStateException("Waybill is already not invoiced");
        }
        waybillStatus.setInvoiced(false);
        repository.save(waybillStatus);
    }
}
