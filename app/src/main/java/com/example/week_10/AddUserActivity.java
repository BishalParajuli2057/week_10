package com.example.week_10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {
    private RadioGroup radioDegreeProgram;
    private EditText firstname, lastname, editemail;
    private CheckBox kandi, maisteri, lisensiaation, tohtoritutkinnon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstname = findViewById(R.id.textFirstName);
        lastname = findViewById(R.id.textLastName);
        editemail = findViewById(R.id.textEmail);
        radioDegreeProgram = findViewById(R.id.textDegreeProgram);
        kandi = findViewById(R.id.bcCheckBox);
        maisteri = findViewById(R.id.msCheckBox);
        lisensiaation = findViewById(R.id.IciCheckBox);
        tohtoritutkinnon = findViewById(R.id.phdCheckBox);
        Button saveUserButton = findViewById(R.id.addUserButton);
        saveUserButton.setOnClickListener(v -> addUser());
    }

    private void addUser() {
        String firstNameStr = firstname.getText().toString();
        String lastNameStr = lastname.getText().toString();
        String emailStr = editemail.getText().toString();
        String degreeProgram = determineDegreeProgram(radioDegreeProgram.getCheckedRadioButtonId());
        boolean kandiChecked = kandi.isChecked();
        boolean maisteriChecked = maisteri.isChecked();
        boolean lisensiaationChecked = lisensiaation.isChecked();
        boolean tohtoritutkinnonChecked = tohtoritutkinnon.isChecked();

        User newUser = new User(firstNameStr, lastNameStr, emailStr, degreeProgram,
                kandiChecked, maisteriChecked, lisensiaationChecked, tohtoritutkinnonChecked);
        UserStorage.getInstance(getApplicationContext()).addUser(newUser);
    }

    private String determineDegreeProgram(int selectedId) {
        if (selectedId == R.id.seRadioButton) return "Software Engineering";
        else if (selectedId == R.id.imRadioButton) return "Information Management";
        else if (selectedId == R.id.ceRadioButton) {
            return "Computer Engineering";
        } else if (selectedId == R.id.eeRadioButton) {
            return "Electrical Engineering";
        }
        return "";
    }
}
