package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button addLutemonActivityButton;
    private Button listLutemonsActivityButton;
    private Button moveLutemonsActivityButton;
    private Button battleFieldActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addLutemonActivityButton = findViewById(R.id.addLutemonActivityButton);
        listLutemonsActivityButton = findViewById(R.id.listLutemonsActivityButton);
        moveLutemonsActivityButton = findViewById(R.id.moveLutemonsActivityButton);
        battleFieldActivityButton = findViewById(R.id.battleFieldActivityButton);
        switchToAddLutemon();
        switchToListLutemons();
        switchToMoveLutemons();
        switchToBattleField();
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

    public void switchToListLutemons() {
        listLutemonsActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showListLutemonsActivity = new Intent(getApplicationContext(), ListLutemonsActivity.class);
                startActivity(showListLutemonsActivity);
            }
        });
    }

    public void switchToMoveLutemons() {
        moveLutemonsActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showMoveLutemosActivity = new Intent(getApplicationContext(), MoveLutemonsActivity.class);
                startActivity(showMoveLutemosActivity);
            }
        });
    }

    public void switchToBattleField() {
        battleFieldActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showBattleFieldActivity = new Intent(getApplicationContext(), BattleFieldActivity.class);
                startActivity(showBattleFieldActivity);
            }
        });
    }
}