package com.example.schedulerdemo.repository;

import com.example.schedulerdemo.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}