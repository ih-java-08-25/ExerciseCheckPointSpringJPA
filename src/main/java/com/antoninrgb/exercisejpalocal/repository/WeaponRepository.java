package com.antoninrgb.exercisejpalocal.repository;

import com.antoninrgb.exercisejpalocal.model.Weapon;
import com.antoninrgb.exercisejpalocal.model.WeaponRange;
import com.antoninrgb.exercisejpalocal.model.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

    // JPA custom methods
    List<Weapon> findByType(WeaponType type);

    Weapon findByName(String name);

    List<Weapon> findByPriceBetween(double minPrice, double maxPrice);

    // JPA queries
    @Query("SELECT w FROM Weapon w WHERE w.range = :range")
    List<Weapon> findAllByRange(@Param("range") WeaponRange range);

    // Native queries
    @Query(value = "SELECT * FROM weapon WHERE stock = 0", nativeQuery = true)
    List<Weapon> findAllByNoStock();


}

