package com.varun.order_management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varun.order_management.constants.CategoryConstants;
import com.varun.order_management.model.Customer;
import com.varun.order_management.model.DiscountDetail;
import com.varun.order_management.model.Order;
import com.varun.order_management.repository.CustomerRepository;
import com.varun.order_management.repository.DiscountDetailRepository;
import com.varun.order_management.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DiscountDetailRepository discountDetailRepository;

    @Override
    public Order createOrder(int customerId, double amount) throws Exception {
        LocalDateTime now = LocalDateTime.now();

        // if customer id not present in the system
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new Exception("Customer not found with customerID:" + customerId));

        int customerOrderCount = customer.getOrderCount();
        customer.setOrderCount(++customerOrderCount); // Increment Order count for the new order

        if (customer.getOrderCount() >= CategoryConstants.PLATINUM_THRESHOLD) { // 20 orders
            customer.setCategory(CategoryConstants.PLATINUM);
        } else if (customer.getOrderCount() >= CategoryConstants.GOLD_THRESHOLD) { // 10 orders
            customer.setCategory(CategoryConstants.GOLD);
        }

        Order newOrder = new Order(customer, amount, now);
        checkForDiscount(customer, newOrder); // provides discount if applicable and stores discount data
        orderRepository.save(newOrder);
        customerRepository.save(customer);
        return newOrder;
    }

    private void checkForDiscount(Customer customer, Order order) { // Helper Function
        if (customer.getCategory().equals(CategoryConstants.REGULAR))
            return; // discount not applicable

        DiscountDetail discountDetail = new DiscountDetail();
        discountDetail.setOrder(order);

        if (customer.getCategory().equals(CategoryConstants.GOLD)) { // IF GOLD CUSTOMER
            discountDetail.setDiscountPercentage(CategoryConstants.GOLD_THRESHOLD);
        } else { // IF PLATINUM CUSTOMER
            discountDetail.setDiscountPercentage(CategoryConstants.PLATINUM_THRESHOLD);
        }
        discountDetailRepository.save(discountDetail);
    }

    @Override
    public Optional<Order> findByOrderId(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
