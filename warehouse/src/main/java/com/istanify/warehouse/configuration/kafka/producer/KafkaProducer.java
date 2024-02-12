package com.istanify.warehouse.configuration.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Objects;


@Component
public class KafkaProducer {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(GenericMessage message) {
        final ListenableFuture<? extends SendResult<String, ?>> listenableResult = (ListenableFuture<? extends SendResult<String, ?>>) kafkaTemplate.send(message);

        listenableResult.addCallback(new ListenableFutureCallback<SendResult<String, ?>>() {
            @Override
            public void onSuccess(SendResult<String, ?> result) {
                if (Objects.isNull(result)) {
                    log.info("Empty result on success for message {}", message);
                    return;
                }
                log.info("Message :{} published, topic : {}, partition : {} and offset : {}", message.getPayload(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to deliver message to kafka", ex);
            }
        });

    }
}