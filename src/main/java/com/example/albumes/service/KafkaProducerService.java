package com.example.albumes.service;

public interface KafkaProducerService {

    void send(String event);
}
