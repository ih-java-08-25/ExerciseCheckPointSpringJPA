package com.example.hellojpainheritance.repository;

import com.example.hellojpainheritance.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface contactRepository extends JpaRepository<Contact, Long> {
}
