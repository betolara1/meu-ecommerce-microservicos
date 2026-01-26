package com.betolara1.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betolara1.order.dto.OrderDTO;
import com.betolara1.order.model.Order;
import com.betolara1.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDTO> getAllOrder(){
        return orderRepository.findAll()
            .stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public OrderDTO getOrderById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderDTO(order);
    }

    public Order updateOrder(Long id, Order updateOrder){
        Order findOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        findOrder.setCustomer_id(updateOrder.getCustomer_id());
        findOrder.setOrder_date(updateOrder.getOrder_date());
        findOrder.setStatus(updateOrder.getStatus());
        findOrder.setTotal_amount(updateOrder.getTotal_amount());
        findOrder.setShipping_address(updateOrder.getShipping_address());

        return orderRepository.save(findOrder);
    }

    public void deleteOrder(Long id){
        Order finOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(finOrder);
    }

}
