package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {

    private Home home = Home.getInstance();
    private RadioGroup lutemonTypeRadioGroup;
    private EditText nameEditText;
    private Button addLutemonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
        lutemonTypeRadioGroup = findViewById(R.id.lutemonTypeRadioGroup);
        nameEditText = findViewById(R.id.nameEditText);
        addLutemonButton = findViewById(R.id.addLutemonButton);
        addLutemon();
    }

    public void addLutemon() {
        addLutemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                switch (lutemonTypeRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.whiteRadioButton:
                        Lutemon white = new White(name);
                        home.createLutemon(white);
                        break;
                    case R.id.greenRadioButton:
                        Lutemon green = new Green(name);
                        home.createLutemon(green);
                        break;
                    case R.id.pinkRadioButton:
                        Lutemon pink = new Pink(name);
                        home.createLutemon(pink);
                        break;
                    case R.id.orangeRadioButton:
                        Lutemon orange = new Orange(name);
                        home.createLutemon(orange);
                        break;
                    case R.id.blackRadioButton:
                        Lutemon black = new Black(name);
                        home.createLutemon(black);
                        break;
                }
                Intent showMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(showMainActivity);
            }
        });
    }
}