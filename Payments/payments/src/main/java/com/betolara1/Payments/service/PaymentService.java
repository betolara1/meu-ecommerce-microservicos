package com.betolara1.Payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betolara1.Payments.DTO.PaymentDTO;
import com.betolara1.Payments.model.Payment;
import com.betolara1.Payments.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentDTO::createPaymentDTO)
                .toList();
    }

    public Payment savPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        return PaymentDTO.createPaymentDTO(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        existingPayment.setOrder_id(updatedPayment.getOrder_id());
        existingPayment.setTransaction_id(updatedPayment.getTransaction_id());
        existingPayment.setPayment_date(updatedPayment.getPayment_date());
        existingPayment.setStatus(updatedPayment.getStatus());
        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setPayment_method(updatedPayment.getPayment_method());

        return paymentRepository.save(existingPayment);
    }
    
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
