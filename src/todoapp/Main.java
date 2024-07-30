package todoapp;

import todoapp.model.User;
import todoapp.service.ToDoList;
import todoapp.service.IAuthenticationService;

import java.util.ArrayList; // Import for ArrayList
import java.util.Scanner; // Import for Scanner

public class Main {
    // Static list of users, acting as a database
    private static ArrayList<User> users = new ArrayList<>();

    // Mock authentication service that returns the first user when logging in
    private static IAuthenticationService authService = new IAuthenticationService() {
        @Override
        public User signUp(String username, String password) {
            // For simplicity, return null (no sign-up logic here)
            return null;
        }

        @Override
        public User logIn(String username, String password) {
            // Return the first user as a mock implementation
            return users.get(0);
        }
    };
    private static boolean isRunning = true;

    public static void main(String[] args) {
        users.add(new User("test", "test"));
        while (isRunning) {
            showMenu();
        }
    }

    public static void showMenu() {
        System.out.println("Welcome to the To-Do List Application!");
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    public static void handleMenu(int choice) {
        switch (choice) {
            case 1:
                onLogIn();
                break;
            case 2:
                // Placeholder for sign-up logic
                System.out.println("Sign-up not implemented.");
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void onLogIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        if (user != null) {
            System.out.println("Welcome, " + user.getUsername() + "!");

            // New code: Create a ToDoList instance with the logged-in user
            ToDoList toDoList = new ToDoList(user);
            toDoList.run(); // Start the to-do list interaction

        } else {
            System.out.println("Invalid credentials or user not found.");
        }
    }

    public static void onExit() {
        isRunning = false;
    }
}
