package com.example.fraud_detection.controller;

import com.example.fraud_detection.model.Transaction;
import com.example.fraud_detection.repository.TransactionRepository;
import com.example.fraud_detection.service.FraudDetectionService;
import com.example.fraud_detection.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private KafkaProducerService kafkaProducerService;


    @PostMapping("/check")
    ResponseEntity<String> checkTransaction(@RequestBody Transaction transaction){
        kafkaProducerService.sendTransaction(transaction);
        return ResponseEntity.ok("Transaction sent to Kafka for processing.");
    }

}
