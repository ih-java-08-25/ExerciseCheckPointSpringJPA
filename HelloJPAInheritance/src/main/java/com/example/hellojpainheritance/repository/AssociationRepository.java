package com.example.hellojpainheritance.repository;

import com.example.hellojpainheritance.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationRepository extends JpaRepository<Association, Long> {
}
