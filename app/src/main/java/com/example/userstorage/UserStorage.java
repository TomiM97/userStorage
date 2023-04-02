package com.example.userstorage;
import android.content.Context;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getLastName().compareTo(user2.getLastName());
            }
        });
    }

    public static UserStorage getInstance() {
        if (userStorageInstance == null) {
            userStorageInstance = new UserStorage();
        }
        return userStorageInstance;
    }

    public void saveUser(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            Log.e("Save User", "Error while saving user data: " + e.getMessage());
        }
    }

    public void loadUser(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjätietojen haku epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Käyttäjätietojen haku epäonnistui");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjätietojen haku epäonnistui");
            e.printStackTrace();
        }
    }

}
