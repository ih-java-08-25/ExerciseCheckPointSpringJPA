package com.example.CupcakeStore.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "cupcake_id", nullable = false)
    private Cupcakes cupcake;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "order_date")
    private LocalDate orderDate = LocalDate.now();

    // Constructors
    public Orders() {}

    public Orders(String customerName, Cupcakes cupcake, Integer quantity) {
        this.customerName = customerName;
        this.cupcake = cupcake;
        this.quantity = quantity;
        this.orderDate = LocalDate.now();
    }

    // Getters and setters
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public Cupcakes getCupcake() { return cupcake; }
    public void setCupcake(Cupcakes cupcake) { this.cupcake = cupcake; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }


}
