package com.example.userstorage;
import java.util.ArrayList;


public class UserStorage {
    private static UserStorage userStorageInstance = null;
    protected ArrayList<User> users = new ArrayList<>();

    public UserStorage() {

    }

    public ArrayList<User> getUsers() {

        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public static UserStorage getInstance() {
        if (userStorageInstance == null) {
            userStorageInstance = new UserStorage();
        }
        return userStorageInstance;
    }
}
