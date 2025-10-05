package com.ironhack.exercisespringjpa.repository;

import com.ironhack.exercisespringjpa.model.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FootballerRepository extends JpaRepository<Footballer, UUID> {
    List<Footballer> findFootballersByNationality(String nationality);
    List<Footballer> findFootballersByPosition(String position);
    public Footballer findFootballerByAge(int age);

    @Query("SELECT f from Footballer f ORDER BY f.age ASC")
    List<Footballer> findFootballersByAgeASC();
    @Query(value = "SELECT * FROM footballer WHERE footballer_name = :footballerName", nativeQuery = true)
    List<Footballer> findFootballerByName(@Param("footballerName") String footballerName);

    String name(String name);
}

