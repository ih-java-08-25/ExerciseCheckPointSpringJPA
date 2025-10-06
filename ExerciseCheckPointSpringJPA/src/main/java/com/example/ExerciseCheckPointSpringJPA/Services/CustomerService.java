package com.example.ExerciseCheckPointSpringJPA.Services;

import com.example.ExerciseCheckPointSpringJPA.Models.Customer;
import com.example.ExerciseCheckPointSpringJPA.Repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
