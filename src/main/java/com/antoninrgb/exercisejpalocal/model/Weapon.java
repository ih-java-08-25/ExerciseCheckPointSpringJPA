package com.antoninrgb.exercisejpalocal.model;

import jakarta.persistence.*;

@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "weapon_range", nullable = false)
    @Enumerated(EnumType.STRING)
    private WeaponRange range;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WeaponRange type;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stock;

    public Weapon(int id, String name, WeaponRange range, WeaponRange type, double price, int stock) {
        this.id = id;
        this.name = name;
        this.range = range;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public Weapon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponRange getRange() {
        return range;
    }

    public void setRange(WeaponRange range) {
        this.range = range;
    }

    public WeaponRange getType() {
        return type;
    }

    public void setType(WeaponRange type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", range=" + range +
                ", type=" + type +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
