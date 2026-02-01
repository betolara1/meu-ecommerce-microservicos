package com.betolara1.Payments.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betolara1.Payments.DTO.PaymentDTO;
import com.betolara1.Payments.model.Payment;
import com.betolara1.Payments.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savPayment(payment);
        PaymentDTO paymentDTO = PaymentDTO.createPaymentDTO(savedPayment);
        return ResponseEntity.ok(paymentDTO);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@RequestBody Long id) {
        PaymentDTO paymentDTO = paymentService.getPaymentById(id);
        return ResponseEntity.ok(paymentDTO);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@RequestBody Payment payment, @PathVariable Long id) {
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        PaymentDTO paymentDTO = PaymentDTO.createPaymentDTO(updatedPayment);
        return ResponseEntity.ok(paymentDTO);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }


}
