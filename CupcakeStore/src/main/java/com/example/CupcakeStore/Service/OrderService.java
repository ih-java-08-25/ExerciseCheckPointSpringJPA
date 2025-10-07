package com.example.CupcakeStore.Service;

import com.example.CupcakeStore.Model.Orders;
import com.example.CupcakeStore.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create an order
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Optional<Orders> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // Find by customer name
    public List<Orders> findByCustomerName(String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }

    // Delete order
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}

