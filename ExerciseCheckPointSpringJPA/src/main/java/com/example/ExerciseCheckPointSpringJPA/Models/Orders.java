package com.example.ExerciseCheckPointSpringJPA.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer units;

    @Column(name = "customer_id")
    private Integer customerId;

    // Constructors
    public Orders(Integer units, Integer customerId) {
        this.units = units;
        this.customerId = customerId;
    }
    public Orders() {}

    // Getters
    public Integer IntegerGetUnits() {
        return units;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}
