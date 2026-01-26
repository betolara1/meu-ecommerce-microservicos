package com.betolara1.order.dto;

import lombok.Data;
import java.sql.Date;

import com.betolara1.order.model.Order;

@Data
public class OrderDTO {
    private Long id;
    private Long customer_id;
    private Date order_date;
    private String status;
    private Long total_amount;
    private String shipping_address;

    public OrderDTO(){}

    public OrderDTO(Order order){
        this.id = order.getId();
        this.customer_id = order.getCustomer_id();
        this.order_date = order.getOrder_date();
        this.status = order.getStatus();
        this.total_amount = order.getTotal_amount();
        this.shipping_address = order.getShipping_address();
    }
}
