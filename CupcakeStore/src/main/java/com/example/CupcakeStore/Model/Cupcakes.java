package com.example.CupcakeStore.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Cupcakes")
public class Cupcakes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cupcake_id")
    private Integer cupcakeId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String flavor;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

    // Constructors
    public Cupcakes() {}

    public Cupcakes(String name, String flavor, BigDecimal price) {
        this.name = name;
        this.flavor = flavor;
        this.price = price;
    }

    // Getters and setters
    public Integer getCupcakeId() { return cupcakeId; }
    public void setCupcakeId(Integer cupcakeId) { this.cupcakeId = cupcakeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFlavor() { return flavor; }
    public void setFlavor(String flavor) { this.flavor = flavor; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
