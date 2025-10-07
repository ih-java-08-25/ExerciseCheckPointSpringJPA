package com.ironhack.exercisechecksolutions.repository;

import com.ironhack.exercisechecksolutions.enums.Attribute;
import com.ironhack.exercisechecksolutions.enums.Currency;
import com.ironhack.exercisechecksolutions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findByAttribute(Attribute attribute);

    List<Transaction> findByCurrency(Currency currency);

    @Query("SELECT t FROM Transaction t WHERE t.accountHolder = ?1")
    List<Transaction> findByAccountHolderName(String accountHolder);
}
