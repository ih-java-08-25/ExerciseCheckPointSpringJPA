package com.ironhack.exercisechecksolutions.model;

import com.ironhack.exercisechecksolutions.enums.AccountType;
import com.ironhack.exercisechecksolutions.enums.Attribute;
import com.ironhack.exercisechecksolutions.enums.Currency;
import com.ironhack.exercisechecksolutions.enums.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "Statement")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Account Holder", nullable = false, length = 50)
    private String accountHolder;

    @Column(name = "Account Name", nullable = false, length = 50)
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Account Type")
    private AccountType accountType;

    @Column(name = "Account IBAN", nullable = false, length = 50)
    private String accountIBAN;

    @Column(name = "Value Time", nullable = false, length = 8)
    private LocalTime valueTime;

    @Column(name = "Value Date", nullable = false, length = 10)
    private LocalDate valueDate;

    @Column(name = "Booking Date", nullable = false, length = 10)
    private LocalDate bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Transaction Type")
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "Currency")
    private Currency currency;

    @Column(name = "Booking Text", nullable = false, length = 160)
    private String bookingText;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "Attribute")
    private Attribute attribute;

    @Column(name = "Category", length = 50)
    private String category;
    @Column(name = "Sub Category", length = 50)
    private String subCategory;

    @Column(name = "Description", length = 50)
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountIBAN() {
        return accountIBAN;
    }

    public void setAccountIBAN(String accountIBAN) {
        this.accountIBAN = accountIBAN;
    }

    public LocalTime getValueTime() {
        return valueTime;
    }

    public void setValueTime(LocalTime valueTime) {
        this.valueTime = valueTime;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getBookingText() {
        return bookingText;
    }

    public void setBookingText(String bookingText) {
        this.bookingText = bookingText;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction(String accountHolder, String accountName, AccountType accountType, String accountIBAN, LocalTime valueTime, LocalDate valueDate, LocalDate bookingDate, TransactionType transactionType, Currency currency, String bookingText, BigDecimal amount, Attribute attribute, String category, String subCategory, String description) {
        this.accountHolder = accountHolder;//"Petros Kostenidis"
        this.accountName = accountName;//"PK_JPM_BANK_3"
        this.accountType = accountType;//"Checking Account"
        this.accountIBAN = accountIBAN;//"US00 0010 4657 6548 9990"
        this.valueTime = valueTime;//15:50:15
        this.valueDate = valueDate;//14/09/2025
        this.bookingDate = bookingDate;//14/09/2025
        this.transactionType = transactionType;//"Debit"
        this.currency = currency;//"USD"
        this.bookingText = bookingText;//"CAFETERIALO MARKO RODA 6767_G4DPFDM5TG"
        this.amount = amount;//17.23
        this.attribute = attribute;//"Expense"
        this.category = category;//"Recreation"
        this.subCategory = subCategory;//"Coffee"
        this.description = description;//"Fredo Espresso, Medium Sugar"
    }

    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", Account Holder='" + accountHolder + '\'' +
                ", Account Name='" + accountName + '\'' +
                ", Account Type='" + accountType + '\'' +
                ", Account IBAN=" + accountIBAN +
                ", Value Time=" + valueTime +
                ", Value Date=" + valueDate +
                ", Booking Date=" + bookingDate +
                ", Transaction Type=" + transactionType +
                ", Currency=" + currency +
                ", Booking Text=" + bookingText +
                ", Amount=" + amount +
                ", Attribute=" + attribute +
                ", Category=" + category +
                ", Sub Category=" + subCategory +
                ", Description=" + description +
                '}';
    }



}

