package com.example.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }
    public List<Order> getAll() {
        return orderRepo.findAll();
    }
}
