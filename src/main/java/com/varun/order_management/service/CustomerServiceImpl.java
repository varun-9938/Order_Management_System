package com.varun.order_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.order_management.constants.CategoryConstants;
import com.varun.order_management.model.Customer;
import com.varun.order_management.model.DiscountDetail;
import com.varun.order_management.repository.CustomerRepository;
import com.varun.order_management.repository.DiscountDetailRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DiscountDetailRepository discountDetailRepository;

    @Override
    public Customer addCustomer(String username) {
        Customer newCustomer = new Customer(username, 0, CategoryConstants.REGULAR);
        return customerRepository.save(newCustomer);
    }

    @Override
    public List<DiscountDetail> findAllDiscountDetails() {
        return discountDetailRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
