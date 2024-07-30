package todoapp.service;

import todoapp.model.User;

import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // Constructor to initialize the users list with a default user
    public AuthenticationService() {
        this.users = new ArrayList<>();
        // Adding a default user (for example purposes)
        this.users.add(new User("defaultUser", "defaultPass"));
    }

    @Override
    public User signUp(String username, String password) {
        // Check if username is already taken
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null; // Username already taken
            }
        }
        // Add new user to the list
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    @Override
    public User logIn(String username, String password) {
        // Check for matching username and password
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Successful login
            }
        }
        return null; // Login failed
    }
}