package com.library.models;

import java.time.LocalDate;

/**
 * Represents a book in the library.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false; // default
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    // Setter that you may already have kept
    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    /**
     * Semantic setter for availability.
     * If available == true -> isIssued = false
     * If available == false -> isIssued = true
     */
    public void setAvailable(boolean available) {
        this.isIssued = !available;
    }

    // ToString (to print book details easily)
    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author +
               ", Status: " + (isIssued ? "Issued" : "Available");
    }
}
