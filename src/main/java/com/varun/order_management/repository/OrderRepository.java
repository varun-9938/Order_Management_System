package com.varun.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varun.order_management.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
