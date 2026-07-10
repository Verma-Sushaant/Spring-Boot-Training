package com.example.KafkaProducerConsumer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.KafkaProducerConsumer.model.Message;
import com.example.KafkaProducerConsumer.repository.MessageRepository;

@Service
public class KafkaProducerService {
    @Autowired
    private MessageRepository messageRepo;

    private final KafkaTemplate<String, String> kafkaTemplate;
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("orders", message);
        messageRepo.save(new Message(message));
        System.out.println("Producer Sent: "+message);
    }
}
