package com.example.ExerciseCheckPointSpringJPA.Controllers;

import com.example.ExerciseCheckPointSpringJPA.Models.Orders;
import com.example.ExerciseCheckPointSpringJPA.Repositories.OrdersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private OrdersRepository ordersRepository;

    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Orders>> findByCustomerId(@RequestParam Integer customerId) {
        List<Orders> ordersList = ordersRepository.findByCustomerId(customerId);
        return ResponseEntity.ok().body(ordersList);
    }
}
