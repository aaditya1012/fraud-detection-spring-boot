package com.example.fraud_detection.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int step;
    private int type;
    private double amount;
    private double oldbalanceOrig;
    private double newbalanceOrig;
    private double oldbalanceDest;
    private double newbalanceDest;
    private boolean isFraud;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getOldbalanceOrig() {
        return oldbalanceOrig;
    }

    public void setOldbalanceOrig(double oldbalanceOrig) {
        this.oldbalanceOrig = oldbalanceOrig;
    }

    public double getNewbalanceOrig() {
        return newbalanceOrig;
    }

    public void setNewbalanceOrig(double newbalanceOrig) {
        this.newbalanceOrig = newbalanceOrig;
    }

    public double getOldbalanceDest() {
        return oldbalanceDest;
    }

    public void setOldbalanceDest(double oldbalanceDest) {
        this.oldbalanceDest = oldbalanceDest;
    }

    public double getNewbalanceDest() {
        return newbalanceDest;
    }

    public void setNewbalanceDest(double newbalanceDest) {
        this.newbalanceDest = newbalanceDest;
    }

    public boolean getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(boolean fraud) {
        isFraud = fraud;
    }
}
