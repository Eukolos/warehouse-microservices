package com.istanify.finance.controller;

import com.istanify.finance.model.WaybillStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.istanify.finance.service.WaybillStatusService;

import java.util.List;

@RestController
@RequestMapping("/waybill-status")
public class WaybillStatusController {
    private final WaybillStatusService waybillStatusService;

    public WaybillStatusController(WaybillStatusService waybillStatusService) {
        this.waybillStatusService = waybillStatusService;
    }

    @GetMapping
    public List<WaybillStatus> getNotInvoicedWaybills() {
        return waybillStatusService.getNotInvoicedWaybills();
    }

}
