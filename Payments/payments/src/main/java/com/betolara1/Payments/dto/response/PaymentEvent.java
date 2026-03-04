package com.betolara1.payments.dto.response;

import java.math.BigDecimal;

public record PaymentEvent(Long orderId, BigDecimal totalPrice) {}
