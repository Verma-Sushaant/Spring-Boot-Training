package com.example.KafkaProducerConsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "orders",groupId = "myGroup")
    public void consume(String message) {
        System.out.println("Consumer Received: "+ message);
    }
}