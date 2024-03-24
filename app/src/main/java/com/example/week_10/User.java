package com.example.week_10;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class User implements Serializable {
    private String firstname, lastname, email, degreeprogram;
    private boolean kandi, maisteri, lisensiaation, tohtoritutkinnon; // Using booleans for checkboxes

    public User(String firstname, String lastname, String email, String degreeProgram,
                boolean kandi, boolean maisteri, boolean lisensiaation, boolean tohtoritutkinnon) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.degreeprogram = degreeProgram;
        this.kandi = kandi;
        this.maisteri = maisteri;
        this.lisensiaation = lisensiaation;
        this.tohtoritutkinnon = tohtoritutkinnon;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeprogram() {
        return degreeprogram;
    }

    public boolean isKandi() {
        return kandi;
    }

    public boolean isMaisteri() {
        return maisteri;
    }

    public boolean isLisensiaation() {
        return lisensiaation;
    }

    public boolean isTohtoritutkinnon() {
        return tohtoritutkinnon;
    }
}


