package com.istanify.warehouse.controller;

import com.istanify.warehouse.dto.WaybillInfoDto;
import com.istanify.warehouse.dto.WaybillRequest;
import com.istanify.warehouse.model.Waybill;
import com.istanify.warehouse.service.WaybillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/waybills")
public class WaybillController {
    private final WaybillService service;

    public WaybillController(WaybillService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Waybill createWaybill(@RequestBody WaybillRequest waybill) {
        return service.createWaybill(waybill);
    }

    @GetMapping
    public List<Waybill> getAllWaybills() {
        return service.getAllWaybills();
    }

    @GetMapping("/{id}")
    public Waybill getWaybill(@PathVariable Long id) {
        return service.getWaybill(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWaybill(@PathVariable Long id) {
        service.deleteWaybill(id);
    }

    @GetMapping("/info/{id}")
    public WaybillInfoDto getWaybillInfo(@PathVariable Long id) {
        return service.getWaybillInfo(id);
    }
}