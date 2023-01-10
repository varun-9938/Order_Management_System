package com.varun.order_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.varun.order_management.model.DiscountDetail;

public interface DiscountDetailRepository extends JpaRepository<DiscountDetail, Integer> {
}
