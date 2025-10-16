package com.example.hellojpainheritance.repository;

import com.example.hellojpainheritance.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
