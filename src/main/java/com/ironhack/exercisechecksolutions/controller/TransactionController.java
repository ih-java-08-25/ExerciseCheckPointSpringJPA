package com.ironhack.exercisechecksolutions.controller;

import com.ironhack.exercisechecksolutions.enums.Attribute;
import com.ironhack.exercisechecksolutions.enums.Currency;
import com.ironhack.exercisechecksolutions.model.Transaction;
import com.ironhack.exercisechecksolutions.service.TransactionService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction){
        return transactionService.create(transaction);
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions(){
        return  transactionService.getAllTransactions();
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable UUID id,@RequestBody Transaction transaction){
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable UUID id) {
        transactionService.deleteTransaction(id);
    }


    @GetMapping("/attribute/{attribute}")
    public List<Transaction> getTransactionsByAttribute(@PathVariable Attribute attribute){
        return  transactionService.findByAttribute(attribute);
    }

    @GetMapping("/currency/{currency}")
    public List<Transaction> getTransactionsByCurrency(@PathVariable Currency currency){
        return  transactionService.findByCurrency(currency);
    }

    @GetMapping("/accountHolder/{accountHolder}")
    public List<Transaction> getTransactionsByAccountHolder(@PathVariable String accountHolder){
        return  transactionService.findByAccountHolderName(accountHolder);
    }


}



