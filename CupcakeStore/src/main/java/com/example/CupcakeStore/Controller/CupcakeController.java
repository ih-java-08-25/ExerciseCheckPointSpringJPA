package com.example.CupcakeStore.Controller;

import com.example.CupcakeStore.Model.Cupcakes;
import com.example.CupcakeStore.Service.CupcakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cupcakes")
public class CupcakeController {

    private final CupcakeService cupcakeService;

    public CupcakeController(CupcakeService cupcakeService) {
        this.cupcakeService = cupcakeService;
    }

    // Get all cupcakes
    @GetMapping
    public List<Cupcakes> getAllCupcakes() {
        return cupcakeService.getAllCupcakes();
    }

    // Get cupcake by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cupcakes> getCupcakeById(@PathVariable Integer id) {
        Optional<Cupcakes> cupcake = cupcakeService.getCupcakeById(id);
        return cupcake.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new cupcake
    @PostMapping
    public Cupcakes createCupcake(@RequestBody Cupcakes cupcake) {
        return cupcakeService.saveCupcake(cupcake);
    }

    // Delete cupcake by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCupcake(@PathVariable Integer id) {
        cupcakeService.deleteCupcake(id);
        return ResponseEntity.noContent().build();
    }

    // Find by flavor
    @GetMapping("/flavor/{flavor}")
    public List<Cupcakes> getCupcakesByFlavor(@PathVariable String flavor) {
        return cupcakeService.findByFlavor(flavor);
    }

    // Find cheaper than a price
    @GetMapping("/cheaper-than/{price}")
    public List<Cupcakes> getCupcakesCheaperThan(@PathVariable BigDecimal price) {
        return cupcakeService.findCheaperThan(price);
    }
}
