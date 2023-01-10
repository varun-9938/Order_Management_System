package com.varun.order_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.order_management.model.Order;
import com.varun.order_management.pojo.OrderRequestPojo;
import com.varun.order_management.service.OrderService;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody OrderRequestPojo orderRequestPojo)
            throws Exception {
        return orderService.createOrder(orderRequestPojo.getCustId(), orderRequestPojo.getAmount());
    }

    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable int id) {
        return orderService.findByOrderId(id).get(); // get() for optional
    }

    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

}
