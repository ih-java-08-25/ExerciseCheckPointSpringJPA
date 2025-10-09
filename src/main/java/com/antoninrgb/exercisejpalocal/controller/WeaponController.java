package com.antoninrgb.exercisejpalocal.controller;

import com.antoninrgb.exercisejpalocal.model.Weapon;
import com.antoninrgb.exercisejpalocal.model.WeaponRange;
import com.antoninrgb.exercisejpalocal.model.WeaponType;
import com.antoninrgb.exercisejpalocal.service.WeaponService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weapons")
public class WeaponController {

    private final WeaponService weaponService;

    WeaponController (WeaponService weaponService) {this.weaponService = weaponService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Weapon add(@RequestBody Weapon weapon) {return weaponService.save(weapon);}

    @GetMapping
    public List<Weapon> getAll() {return weaponService.findAll();}

    @GetMapping("/type/{type}")
    public List<Weapon> getByType(@PathVariable WeaponType type) {return weaponService.findByType(type);}

    @GetMapping("/name/{name}")
    public Weapon getByName(@PathVariable String name) {return weaponService.findByName(name);}

    @GetMapping("/price")
    public List<Weapon> getByPriceRange(@RequestParam double minPrice, double maxPrice) {return weaponService.findByPriceRange(minPrice, maxPrice);}

    @GetMapping("/range/{range}")
    public List<Weapon> getByRange(@PathVariable WeaponRange range) {return weaponService.findByRange(range);}

    @GetMapping("/stock")
    public List<Weapon> getOutOfStock() {return weaponService.findOutOfStock();}

}
