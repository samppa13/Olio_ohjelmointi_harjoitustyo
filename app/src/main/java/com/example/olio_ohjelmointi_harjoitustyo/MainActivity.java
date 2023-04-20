package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button addLutemonActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addLutemonActivityButton = findViewById(R.id.addLutemonActivityButton);
        switchToAddLutemon();
    }

    public void switchToAddLutemon() {
        addLutemonActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showAddLutemonActivity = new Intent(getApplicationContext(), AddLutemonActivity.class);
                startActivity(showAddLutemonActivity);
            }
        });
    }
}