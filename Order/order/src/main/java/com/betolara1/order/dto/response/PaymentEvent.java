package com.betolara1.order.dto.response;

import java.math.BigDecimal;

public record PaymentEvent(Long orderId, BigDecimal totalPrice) {}
