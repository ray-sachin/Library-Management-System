package com.library.main;

import com.library.models.*;
import com.library.services.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookService bookService = new BookService();
        UserService userService = new UserService();
        TransactionService transactionService = new TransactionService(bookService);

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println(" SMART LIBRARY MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1 Add Book");
            System.out.println("2 Display All Books");
            System.out.println("3 Add User");
            System.out.println("4 Display All Users");
            System.out.println("5 Issue Book");
            System.out.println("6 Return Book");
            System.out.println("7 View Transactions");
            System.out.println("0 Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    Book book = new Book(bookId, title, author);
                    bookService.addBook(book);
                    break;

                case 2:
                    bookService.displayAllBooks();
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    User user = new User(userId, userName, email);
                    userService.addUser(user);
                    break;

                case 4:
                    userService.displayAllUsers();
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    User issueUser = userService.getUserById(uid);
                    if (issueUser == null) {
                        System.out.println("❌ User not found!");
                        break;
                    }

                    System.out.print("Enter Book Title: ");
                    String issueTitle = sc.nextLine();
                    Book issueBook = bookService.searchBook(issueTitle);
                    transactionService.issueBook(issueUser, issueBook);
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    int rid = sc.nextInt(); sc.nextLine();
                    User returnUser = userService.getUserById(rid);
                    if (returnUser == null) {
                        System.out.println("❌ User not found!");
                        break;
                    }

                    System.out.print("Enter Book Title: ");
                    String returnTitle = sc.nextLine();
                    Book returnBook = bookService.searchBook(returnTitle);
                    if (returnBook == null) {
                        System.out.println("❌ Book not found!");
                        break;
                    }

                    transactionService.returnBook(returnUser, returnBook);
                    break;

                case 7:
                    transactionService.displayAllTransactions();
                    break;

                case 0:
                    System.out.println("👋 Exiting the system... Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
