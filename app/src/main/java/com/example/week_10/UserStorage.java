package com.example.week_10;

// Lisää seuraavat import-lauseet:
import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();
    private static UserStorage instance = null;

    // Contextia käytetään tiedostojen sijainnin määrittämiseen
    private Context context;

    private UserStorage(Context context) {
        this.context = context;
    }

    public static synchronized UserStorage getInstance(Context context) {
        if (instance == null) {
            instance = new UserStorage(context);
        }
        return instance;
    }

    public void saveUsersToFile() {
        try {
            FileOutputStream fos = context.openFileOutput("users.data", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addUser(User user) {
        users.add(user);
        saveUsersToFile();
    }
    public void loadUsersFromFile() {
        try {
            FileInputStream fis = context.openFileInput("users.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<User>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
