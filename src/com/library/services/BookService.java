package com.library.services;

import com.library.models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    // Search book by title (case-insensitive, partial match)
    public Book searchBook(String title) {
        if (title == null) return null;
        String q = title.trim().toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(q)) {
                return book;
            }
        }
        return null;
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\nList of Available Books:");
            for (Book book : books) {
                System.out.println(book);
                System.out.println("--------------------");
            }
        }
    }

    // Update book availability when issued or returned
    public void updateBookAvailability(Book book, boolean isAvailable) {
        if (book == null) return;
        book.setAvailable(isAvailable);
    }

    // Get the book list (for other services to use)
    public List<Book> getBooks() {
        return books;
    }
}
