package com.library.models;

import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private User user;
    private Book book;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;

    public Transaction(int transactionId, User user, Book book, LocalDate issueDate, LocalDate dueDate) {
        this.transactionId = transactionId;
        this.user = user;
        this.book = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = null; // not returned yet
        this.fine = 0.0;
    }

    // Getters and setters
    public int getTransactionId() {
        return transactionId;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                "\nUser: " + user.getName() +
                "\nBook: " + book.getTitle() +
                "\nIssued on: " + issueDate +
                "\nDue on: " + dueDate +
                (returnDate != null ? "\nReturned on: " + returnDate : "\nNot yet returned") +
                "\nFine: ₹" + fine;
    }
}
