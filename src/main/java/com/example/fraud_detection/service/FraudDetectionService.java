package com.example.fraud_detection.service;

import com.example.fraud_detection.model.Transaction;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FraudDetectionService {

     private final String FASTAPI_URL =   "http://127.0.0.1:5000/predict";

     public boolean checkFraud(Transaction transaction){
         RestTemplate restTemplate = new RestTemplate();

         Map<String, Object> requestBody = getRequestBody(transaction);

         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         HttpEntity<Map<String,Object>> requestEntity= new HttpEntity<>(requestBody,headers);

         ResponseEntity<Map> response = restTemplate.exchange(FASTAPI_URL,HttpMethod.POST,requestEntity,Map.class);
         return (boolean) response.getBody().get("is_fraud");

     }

    private static Map<String, Object> getRequestBody(Transaction transaction) {
        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("step", transaction.getStep());
        requestBody.put("type", transaction.getType());
        requestBody.put("amount", transaction.getAmount());
        requestBody.put("oldbalanceOrg", transaction.getOldbalanceOrig());
        requestBody.put("newbalanceOrig", transaction.getNewbalanceOrig());
        requestBody.put("oldbalanceDest", transaction.getOldbalanceDest());
        requestBody.put("newbalanceDest", transaction.getNewbalanceDest());
        return requestBody;
    }

}
