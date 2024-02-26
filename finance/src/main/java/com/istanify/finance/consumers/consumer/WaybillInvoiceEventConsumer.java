package com.istanify.finance.consumers.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.istanify.finance.consumers.model.WaybillRecordEvent;
import com.istanify.finance.service.WaybillQueueService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class WaybillInvoiceEventConsumer {
    private final WaybillQueueService service;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WaybillInvoiceEventConsumer.class);

    public WaybillInvoiceEventConsumer(WaybillQueueService service) {
        this.service = service;
    }


    @KafkaListener(topics = "${kafka.topics.waybill-invoice.topic}",
            groupId = "${kafka.topics.waybill-invoice.consumerGroup}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeWaybillRecordEvent(@Payload String eventData,
                                          @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws JsonProcessingException {
        log.info(eventData.toString()+"---------------------------------------------------------------------------");
        log.info("WaybillInvoiceEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from topic : {} " +
                        "thread : {} ",
                eventData, topic, Thread.currentThread().getName());
        ObjectMapper objectMapper = new ObjectMapper();

        WaybillRecordEvent waybillRecordEvent = objectMapper.readValue(eventData, WaybillRecordEvent.class);

        log.warn(waybillRecordEvent.toString());


        service.saveWaybill(waybillRecordEvent);;

    }

}
