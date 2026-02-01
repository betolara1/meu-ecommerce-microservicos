package com.betolara1.Payments.model;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long order_id;
    private String transaction_id;
    private Time payment_date;
    private Status status;
    private int amount;
    private String payment_method;

    public enum Status {
        PENDING,
        COMPLETED,
        FAILED,
        REFUNDED
    }


}
