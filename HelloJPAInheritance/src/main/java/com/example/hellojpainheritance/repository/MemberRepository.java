package com.example.hellojpainheritance.repository;

import com.example.hellojpainheritance.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
