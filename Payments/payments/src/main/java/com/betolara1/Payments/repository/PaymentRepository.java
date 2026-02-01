package com.betolara1.Payments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betolara1.Payments.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
