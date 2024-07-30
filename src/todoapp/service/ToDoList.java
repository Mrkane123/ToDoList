package todoapp.service;

import todoapp.model.ToDoItem;
import todoapp.model.User;

import java.util.Scanner;

public class ToDoList {
    private User user;
    private boolean isRunning;

    public ToDoList(User user) {
        this.user = user;
        this.isRunning = true;
    }

    private void showMenu() {
        System.out.println("1. Show all items");
        System.out.println("2. Add an item");
        System.out.println("3. Mark an item as done");
        System.out.println("4. Mark an item as undone");
        System.out.println("5. Delete an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    public void run() {
        while (isRunning) {
            showMenu();
        }
    }

    public void handleMenu(int choice) {
        switch (choice) {
            case 1:
                onShowAllItems();
                break;
            case 2:
                onAddItem();
                break;
            case 3:
                onMarkAsDone();
                break;
            case 4:
                onMarkAsUndone();
                break;
            case 5:
                onDeleteItem();
                break;
            case 6:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void onShowAllItems() {
        for (int i = 0; i < user.getToDoItems().size(); i++) {
            ToDoItem item = user.getToDoItems().get(i);
            if (item.isDone()) {
                System.out.println(i + ". [X] " + item.getDescription());
            } else {
                System.out.println(i + ". [ ] " + item.getDescription());
            }
        }
    }

    public void onAddItem() {
        System.out.print("Enter the description of the item: ");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        user.getToDoItems().add(new ToDoItem(description)); // Add the new item to the list
    }

    public void onMarkAsDone() {
        onShowAllItems();
        System.out.print("Enter the number of the item to mark as done: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        if (itemNumber >= 0 && itemNumber < user.getToDoItems().size()) {
            user.getToDoItems().get(itemNumber).setDone(true); // Mark item as done
        } else {
            System.out.println("Invalid item number!");
        }
    }

    public void onMarkAsUndone() {
        onShowAllItems();
        System.out.print("Enter the number of the item to mark as undone: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        if (itemNumber >= 0 && itemNumber < user.getToDoItems().size()) {
            user.getToDoItems().get(itemNumber).setDone(false); // Mark item as undone
        } else {
            System.out.println("Invalid item number!");
        }
    }

    public void onDeleteItem() {
        onShowAllItems();
        System.out.print("Enter the number of the item to delete: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        if (itemNumber >= 0 && itemNumber < user.getToDoItems().size()) {
            user.getToDoItems().remove(itemNumber); // Remove item from list
        } else {
            System.out.println("Invalid item number!");
        }
    }

    public void onExit() {
        isRunning = false;
    }
}
