package com.library.services;

import com.library.models.User;
import java.util.ArrayList;

public class UserService {
    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    // Add new user
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully: " + user.getName());
    }

    // Search user by ID
    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Search user by name (case-insensitive)
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    // Display all users
    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered in the library yet.");
        } else {
            System.out.println("\n👥 Registered Users:");
            for (User user : users) {
                System.out.println(user);
                System.out.println("--------------------");
            }
        }
    }

    // Return all users list (for other services to use)
    public ArrayList<User> getUsers() {
        return users;
    }
}
