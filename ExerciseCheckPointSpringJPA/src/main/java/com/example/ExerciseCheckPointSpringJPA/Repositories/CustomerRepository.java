package com.example.ExerciseCheckPointSpringJPA.Repositories;

import com.example.ExerciseCheckPointSpringJPA.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findById(Integer id);
    Optional<Customer> findByLastName(String lastName);
}
