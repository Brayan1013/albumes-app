package com.example.albumes.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@AllArgsConstructor
@Log4j2
public class KafkaProducerServiceImpl implements KafkaProducerService{

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String event) {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("events-web", event);
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("it was an error sending information :(");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("The information was sent correctly");
            }
        });
    }
}
