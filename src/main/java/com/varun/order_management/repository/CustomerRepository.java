package com.varun.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varun.order_management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
