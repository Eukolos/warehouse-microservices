package com.eukolos.stock.consumers.consumer;

import com.eukolos.stock.consumers.model.WaybillRecordEvent;
import com.eukolos.stock.model.Stock;
import com.eukolos.stock.service.StockService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class WaybillRecordEventConsumer {
    private final StockService service;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WaybillRecordEventConsumer.class);

    public WaybillRecordEventConsumer(StockService service) {
        this.service = service;
    }


    @KafkaListener(topics = "${kafka.topics.waybill-record.topic}",
            groupId = "${kafka.topics.waybill-record.consumerGroup}",
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void consumeCreatedUserEvent(@Payload WaybillRecordEvent eventData,
                                        @Headers ConsumerRecord<String, Object> consumerRecord) {
        log.info("UserCreatedEventConsumer.consumeApprovalRequestResultedEvent consumed EVENT :{} " +
                        "from partition : {} " +
                        "with offset : {} " +
                        "thread : {} " +
                        "for message key: {}",
                eventData, consumerRecord.partition(), consumerRecord.offset(), Thread.currentThread().getName(), consumerRecord.key());

        Stock entity = Stock.EventToNotificationEntity(eventData);

        service.save(entity);

    }

}
