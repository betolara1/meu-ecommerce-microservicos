package com.betolara1.order.controller;

import java.util.List;

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

import com.betolara1.order.dto.OrderDTO;
import com.betolara1.order.model.Order;
import com.betolara1.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody Order order){
        Order newOrder = orderService.saveOrder(order);
        OrderDTO orderDTO = new OrderDTO(newOrder);

        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        OrderDTO orderId = orderService.getOrderById(id);
        return ResponseEntity.ok(orderId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody Order order){
        Order orderDb = orderService.updateOrder(id, order);
        OrderDTO orderDTO = new OrderDTO(orderDb);

        return ResponseEntity.ok(orderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }

}
