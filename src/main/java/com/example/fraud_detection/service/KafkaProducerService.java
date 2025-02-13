package com.example.fraud_detection.service;

import com.example.fraud_detection.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC ="transaction-events";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendTransaction(Transaction transaction){
        try{
            String transactionJson = objectMapper.writeValueAsString(transaction);
            kafkaTemplate.send(TOPIC,transactionJson);
            System.out.println("Transaction sent to Kafka: " + transactionJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
