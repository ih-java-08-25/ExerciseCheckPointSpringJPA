package com.antoninrgb.exercisejpalocal.service;

import com.antoninrgb.exercisejpalocal.model.Weapon;
import com.antoninrgb.exercisejpalocal.model.WeaponRange;
import com.antoninrgb.exercisejpalocal.model.WeaponType;
import com.antoninrgb.exercisejpalocal.repository.WeaponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    WeaponService(WeaponRepository weaponRepository) {this.weaponRepository = weaponRepository;}

    public Weapon save(Weapon weapon) {
        System.out.println("Adding " + weapon.getName() + " to the database,,,");
        return weaponRepository.save(weapon);
    }

    public List<Weapon> findAll() {
        System.out.println("Retrieving weapon database...");
        return weaponRepository.findAll();
    }

    public List<Weapon> findByType(WeaponType type) {return weaponRepository.findByType(type);}

    public Weapon findByName(String name) {return weaponRepository.findByName(name);}

    public List<Weapon> findByPriceRange(double minPrice, double maxPrice) {return weaponRepository.findByPriceBetween(minPrice, maxPrice);}

    public List<Weapon> findByRange(WeaponRange range) {
        return weaponRepository.findAllByRange(range);
    }

    public List<Weapon> findOutOfStock() {return weaponRepository.findAllByNoStock();}
}
