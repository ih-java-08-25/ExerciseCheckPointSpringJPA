package com.example.CupcakeStore.Service;

import com.example.CupcakeStore.Model.Cupcakes;
import com.example.CupcakeStore.Repository.CupcakeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CupcakeService {

    private final CupcakeRepository cupcakeRepository;

    public CupcakeService(CupcakeRepository cupcakeRepository) {
        this.cupcakeRepository = cupcakeRepository;
    }

    // Create a cupcake
    public Cupcakes saveCupcake(Cupcakes cupcake) {
        return cupcakeRepository.save(cupcake);
    }

    // Get all cupcakes
    public List<Cupcakes> getAllCupcakes() {
        return cupcakeRepository.findAll();
    }

    // Get cupcake by ID
    public Optional<Cupcakes> getCupcakeById(Integer id) {
        return cupcakeRepository.findById(id);
    }

    // Find by flavor
    public List<Cupcakes> findByFlavor(String flavor) {
        return cupcakeRepository.findByFlavor(flavor);
    }

    // Find cheaper than a price
    public List<Cupcakes> findCheaperThan(BigDecimal price) {
        return cupcakeRepository.findByPriceLessThan(price);
    }

    // Delete cupcake
    public void deleteCupcake(Integer id) {
        cupcakeRepository.deleteById(id);
    }
}