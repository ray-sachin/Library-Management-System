package com.library.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    // Get today's date
    public static LocalDate getTodayDate() {
        return LocalDate.now();
    }

    // Get the due date (today + number of days)
    public static LocalDate getDueDate(int days) {
        return LocalDate.now().plusDays(days);
    }

    // Calculate days between two dates
    public static long calculateDaysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    // Check if a book is overdue
    public static boolean isOverdue(LocalDate dueDate) {
        return LocalDate.now().isAfter(dueDate);
    }
}