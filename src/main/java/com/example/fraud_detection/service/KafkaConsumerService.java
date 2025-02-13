package com.example.fraud_detection.service;

import com.example.fraud_detection.model.Transaction;
import com.example.fraud_detection.repository.TransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "transaction-events" ,groupId = "fraud-detection-group")
    public void processTransaction(String message){
        try{
            Transaction transaction = objectMapper.readValue(message, Transaction.class);

            boolean isFraud = fraudDetectionService.checkFraud(transaction);
            transaction.setIsFraud(isFraud);

            transactionRepository.save(transaction);
            System.out.println("Processed Transaction: " + transaction);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
