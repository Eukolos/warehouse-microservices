package com.istanify.warehouse.configuration.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;


@Component
public class KafkaProducer {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(GenericMessage message) {
        CompletableFuture<SendResult<String, Object>> listenableResult = kafkaTemplate.send(message);

        listenableResult.acceptEither(
                listenableResult,
                (result) -> {
                    log.info("Message sent to topic: " + result.getRecordMetadata().topic());
                }
        );
    }

}