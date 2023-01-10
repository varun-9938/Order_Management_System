package com.varun.order_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varun.order_management.model.Customer;
import com.varun.order_management.model.DiscountDetail;
import com.varun.order_management.pojo.CustomerRequestPojo;
import com.varun.order_management.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody CustomerRequestPojo customerRequestPojo) {
        return customerService.addCustomer(customerRequestPojo.getUsername());
    }

    @GetMapping("/discountDetail")
    public List<DiscountDetail> findAllCustomerDiscountDetails() {
        return customerService.findAllDiscountDetails();
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id).get(); // returns Optional so using get()
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

}
