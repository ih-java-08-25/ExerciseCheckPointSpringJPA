package com.example.ExerciseCheckPointSpringJPA.Services;

import com.example.ExerciseCheckPointSpringJPA.Models.Orders;
import com.example.ExerciseCheckPointSpringJPA.Repositories.CustomerRepository;
import com.example.ExerciseCheckPointSpringJPA.Repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findAllOrders(Integer customerId) {
        return ordersRepository.findByCustomerId(customerId);
    }
}
