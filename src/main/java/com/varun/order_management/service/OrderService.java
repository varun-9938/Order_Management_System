package com.varun.order_management.service;

import java.util.List;
import java.util.Optional;

import com.varun.order_management.model.Order;

public interface OrderService {
    public Order createOrder(int customerId, double amount) throws Exception;

    public Optional<Order> findByOrderId(int id);

    public List<Order> findAllOrders();
}
