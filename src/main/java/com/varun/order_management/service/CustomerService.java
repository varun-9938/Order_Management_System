package com.varun.order_management.service;

import java.util.List;
import java.util.Optional;

import com.varun.order_management.model.Customer;
import com.varun.order_management.model.DiscountDetail;

public interface CustomerService {
    public Customer addCustomer(String username);

    public List<DiscountDetail> findAllDiscountDetails();

    public Optional<Customer> findCustomerById(int id);

    public List<Customer> findAllCustomers();
}
