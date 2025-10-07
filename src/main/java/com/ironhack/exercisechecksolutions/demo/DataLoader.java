package com.ironhack.exercisechecksolutions.demo;

import com.ironhack.exercisechecksolutions.enums.AccountType;
import com.ironhack.exercisechecksolutions.enums.Attribute;
import com.ironhack.exercisechecksolutions.enums.Currency;
import com.ironhack.exercisechecksolutions.enums.TransactionType;
import com.ironhack.exercisechecksolutions.model.Transaction;
import com.ironhack.exercisechecksolutions.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final TransactionService transactionService;

    public DataLoader(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading initial data...");
        if (!transactionService.getAllTransactions().isEmpty()) {
            System.out.println("Data already loaded, skipping...");
            return;
        }

        var transaction1 = new Transaction("Petros Kostenidis",
                "PK_JPM_BANK_3",
                AccountType.CHECKING_ACCOUNT,
                "US00 0010 4657 6548 9990",
                LocalTime.of(15,50,15),
                LocalDate.of(2025,9,14),
                LocalDate.of(2025,9,14),
                TransactionType.DEBIT,
                Currency.USD,
                "CAFETERIALO MARKO RODA 6767_G4DPFDM5TG",
                BigDecimal.valueOf(17.23),
                Attribute.Expense,
                "Recreation",
                "Coffee",
                "Fredo Espresso,Medium Sugar");
        transactionService.create(transaction1);
        System.out.println("Data loaded!");

        var transaction2 = new Transaction("Petros Kostenidis",
                "PK_JPM_BANK_2",
                AccountType.CHECKING_ACCOUNT,
                "US200 0010 4657 6548 9990",
                LocalTime.of(19,50,15),
                LocalDate.of(2025,9,4),
                LocalDate.of(2025,9,5),
                TransactionType.DEBIT,
                Currency.USD,
                "ELECTROPLANET Laptop 965DC85D",
                BigDecimal.valueOf(800.20),
                Attribute.Expense,
                "Electronic Device",
                "Laptop",
                "Lenovo 656hx");
        transactionService.create(transaction1);
        System.out.println("Data loaded!");

        var transaction3 = new Transaction("Petros Kostenidis",
                "PK_JPM_BANK_3",
                AccountType.CHECKING_ACCOUNT,
                "US00 0010 4657 6548 9990",
                LocalTime.of(17,50,02),
                LocalDate.of(2025,9,02),
                LocalDate.of(2025,9,02),
                TransactionType.DEBIT,
                Currency.USD,
                "FURNITURAKIA 858585 ASDL",
                BigDecimal.valueOf(17.23),
                Attribute.Expense,
                "Household",
                "Furniture",
                "Sofa");

        transactionService.create(transaction1);
        transactionService.create(transaction2);
        transactionService.create(transaction3);
        System.out.println("Data loaded!");



    }
}