package com.eukolos.stock.consumers.consumer;

import com.eukolos.stock.consumers.model.WaybillRecordEvent;
import com.eukolos.stock.model.Stock;
import com.eukolos.stock.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WaybillRecordEventConsumer {
    private final StockService service;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WaybillRecordEventConsumer.class);

    public WaybillRecordEventConsumer(StockService service) {
        this.service = service;
    }


    @KafkaListener(topics = "${kafka.topics.waybill-record.topic}",
            groupId = "${kafka.topics.waybill-record.consumerGroup}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeWaybillRecordEvent(@Payload String eventData,
                                          @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) throws JsonProcessingException {
        log.info(eventData.toString()+"---------------------------------------------------------------------------");
        log.info("WaybillRecordEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from topic : {} " +
                        "thread : {} ",
                eventData, topic, Thread.currentThread().getName());
        ObjectMapper objectMapper = new ObjectMapper();

        WaybillRecordEvent waybillRecordEvent = objectMapper.readValue(eventData, WaybillRecordEvent.class);

        log.warn(waybillRecordEvent.toString());
        Stock entity = Stock.EventToNotificationEntity(waybillRecordEvent);

//       service.save(entity);

    }

}
