package com.example.ExerciseCheckPointSpringJPA.Controllers;

import com.example.ExerciseCheckPointSpringJPA.Models.Customer;
import com.example.ExerciseCheckPointSpringJPA.Services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customerList = customerService.findAllCustomers();
        return ResponseEntity.ok().body(customerList);
    }

    @GetMapping("/id/{customerId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable Integer customerId) {
        Optional<Customer> customerList = customerService.findById(customerId);
        return ResponseEntity.ok().body(customerList);
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<Optional<Customer>> findByLastName(@PathVariable String lastName) {
        Optional<Customer> customerList = customerService.findByLastName(lastName);
        return ResponseEntity.ok().body(customerList);
    }
}
