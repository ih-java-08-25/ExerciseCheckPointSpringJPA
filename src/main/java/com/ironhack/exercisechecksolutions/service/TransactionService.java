package com.ironhack.exercisechecksolutions.service;

import com.ironhack.exercisechecksolutions.enums.Attribute;
import com.ironhack.exercisechecksolutions.enums.Currency;
import com.ironhack.exercisechecksolutions.model.Transaction;
import com.ironhack.exercisechecksolutions.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    // CRUD   - SQL    - HTTP
    //------------------------
    // Create = Insert = POST
    // Read   = Select = GET
    // Update = Update = PUT/PATCH
    // Delete = Delete = DELETE

    // Create
    public Transaction create(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    // Read
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    // Update
    public Transaction updateTransaction(UUID id,Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        existingTransaction.setAccountHolder(transaction.getAccountHolder());
        existingTransaction.setAccountName(transaction.getAccountName());
        existingTransaction.setAccountType(transaction.getAccountType());
        existingTransaction.setAccountIBAN(transaction.getAccountIBAN());
        existingTransaction.setValueTime(transaction.getValueTime());
        existingTransaction.setValueDate(transaction.getValueDate());
        existingTransaction.setBookingDate(transaction.getBookingDate());
        existingTransaction.setTransactionType(transaction.getTransactionType());
        existingTransaction.setCurrency(transaction.getCurrency());
        existingTransaction.setBookingText(transaction.getBookingText());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setAttribute(transaction.getAttribute());
        existingTransaction.setCategory(transaction.getCategory());
        existingTransaction.setSubCategory(transaction.getSubCategory());
        existingTransaction.setDescription(transaction.getDescription());
        return transactionRepository.save(existingTransaction);
    }

    //Delete
    public void deleteTransaction(UUID id){
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        transactionRepository.delete(existingTransaction);
    }

    public List<Transaction> findByAttribute(Attribute attribute) {
        return transactionRepository.findByAttribute(attribute);
    }

    public List<Transaction> findByCurrency(Currency currency) {
        return transactionRepository.findByCurrency(currency);
    }

    public List<Transaction> findByAccountHolderName(String accountHolder) {
        return transactionRepository.findByAccountHolderName(accountHolder);
    }


}















