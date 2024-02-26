package com.istanify.finance.service;

import com.istanify.finance.consumers.model.WaybillRecordEvent;
import com.istanify.finance.model.WaybillStatus;
import com.istanify.finance.repository.WaybillStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class WaybillQueueService {

    private final WaybillStatusRepository waybillStatusRepository;

    public WaybillQueueService(WaybillStatusRepository waybillStatusRepository) {
        this.waybillStatusRepository = waybillStatusRepository;
    }

    public void saveWaybill(WaybillRecordEvent waybillRecordEvent) {
        waybillStatusRepository.save(new WaybillStatus(
                waybillRecordEvent.getWaybillId(),
                false
        ));
    }


}
