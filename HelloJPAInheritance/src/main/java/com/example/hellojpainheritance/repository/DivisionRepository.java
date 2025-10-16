package com.example.hellojpainheritance.repository;

import com.example.hellojpainheritance.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByName(String name);
}
