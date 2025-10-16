package com.example.hellojpainheritance.repository;

import com.example.hellojpainheritance.enums.GuestStatus;
import com.example.hellojpainheritance.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}
