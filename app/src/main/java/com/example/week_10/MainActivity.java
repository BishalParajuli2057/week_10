package com.example.week_10;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button addusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserStorage.getInstance(this).loadUsersFromFile();
        addusers = findViewById(R.id.addUserButton);
        addusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAdduser(v);
            }
        });
    }

    public void setAdduser(View view){
        Intent intent= new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }
}

