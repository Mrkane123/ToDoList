package todoapp.model;

import java.util.ArrayList;


public class User {
    private String username;
    private String password;
    private ArrayList<ToDoItem> toDoItems;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.toDoItems = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Gets the to-do items of the user.
     * @return A reference to the list of to-do items, which can be modified from outside the class.
     */
    public ArrayList<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    // Optionally, you can add methods to manipulate the to-do list directly
    public void addToDoItem(ToDoItem item) {
        toDoItems.add(item);
    }

    public void removeToDoItem(ToDoItem item) {
        toDoItems.remove(item);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", toDoItems=" + toDoItems +
                '}';
    }
}

