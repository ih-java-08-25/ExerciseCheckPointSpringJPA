package com.example.CupcakeStore.Repository;

import com.example.CupcakeStore.Model.Cupcakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CupcakeRepository extends JpaRepository<Cupcakes, Integer> {
    List<Cupcakes> findByFlavor(String flavor);
    List<Cupcakes> findByPriceLessThan(java.math.BigDecimal price);
}
