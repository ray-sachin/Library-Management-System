package com.library.services;

import com.library.models.Book;
import com.library.models.User;
import com.library.models.Transaction;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class TransactionService {
    private ArrayList<Transaction> transactions;
    private BookService bookService;

    public TransactionService(BookService bookService) {
        this.bookService = bookService;
        this.transactions = new ArrayList<>();
    }

    // Issue a book to a user
    public void issueBook(User user, Book book) {
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued to someone else.");
            return;
        }

        // Set book as issued
        bookService.updateBookAvailability(book, false);

        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(14); // 2 weeks loan period
        Transaction transaction = new Transaction(transactions.size() + 1, user, book, issueDate, dueDate);

        transactions.add(transaction);
        System.out.println("Book issued successfully to " + user.getName());
        System.out.println("Due Date: " + dueDate);
    }

    // Return a book
    public void returnBook(User user, Book book) {
        for (Transaction transaction : transactions) {
            if (transaction.getUser().getId() == user.getId() &&
                transaction.getBook().getId() == book.getId() &&
                transaction.getReturnDate() == null) {

                LocalDate returnDate = LocalDate.now();
                transaction.setReturnDate(returnDate);

                long daysLate = ChronoUnit.DAYS.between(transaction.getDueDate(), returnDate);
                double fine = (daysLate > 0) ? daysLate * 5.0 : 0.0; // ₹5 per late day
                transaction.setFine(fine);

                bookService.updateBookAvailability(book, true);
                System.out.println("Book returned successfully by " + user.getName());
                if (fine > 0)
                    System.out.println("Late return! Fine: ₹" + fine);
                else
                    System.out.println("No fine. Returned on time.");
                return;
            }
        }
        System.out.println("No active transaction found for this user and book.");
    }

    // Display all transactions
    public void displayAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\nTransaction History:");
            for (Transaction t : transactions) {
                System.out.println(t);
                System.out.println("--------------------");
            }
        }
    }
}
