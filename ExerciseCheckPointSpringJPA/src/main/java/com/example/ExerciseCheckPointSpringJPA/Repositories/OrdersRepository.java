package com.example.ExerciseCheckPointSpringJPA.Repositories;

import com.example.ExerciseCheckPointSpringJPA.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomerId(Integer id);
}
