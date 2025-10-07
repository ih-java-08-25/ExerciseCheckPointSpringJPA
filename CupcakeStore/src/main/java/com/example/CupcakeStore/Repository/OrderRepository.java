package com.example.CupcakeStore.Repository;

import com.example.CupcakeStore.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByCustomerName(String customerName);
}
