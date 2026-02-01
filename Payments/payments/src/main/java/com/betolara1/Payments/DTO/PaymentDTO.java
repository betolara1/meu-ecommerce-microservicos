package com.betolara1.Payments.DTO;

import java.sql.Time;

import com.betolara1.Payments.model.Payment;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long id;
    private Long order_id;
    private String transaction_id;
    private Time payment_date;
    private Status status;
    private int amount;
    private String payment_method;


    private enum Status {
        PENDING,
        COMPLETED,
        FAILED,
        REFUNDED
    }


    private PaymentDTO(){}

    public static PaymentDTO createPaymentDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        
        paymentDTO.id = payment.getId();
        paymentDTO.order_id = payment.getOrder_id();
        paymentDTO.transaction_id = payment.getTransaction_id();
        paymentDTO.payment_date = payment.getPayment_date();
        paymentDTO.status = Status.valueOf(payment.getStatus().name());
        paymentDTO.amount = payment.getAmount();
        paymentDTO.payment_method = payment.getPayment_method();
        return paymentDTO;
    }
}
