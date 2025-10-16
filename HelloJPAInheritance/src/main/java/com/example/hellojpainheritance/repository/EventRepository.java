package com.example.hellojpainheritance.repository;

import com.example.hellojpainheritance.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
