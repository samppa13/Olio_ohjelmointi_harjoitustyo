package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MoveLutemonsActivity extends AppCompatActivity {
    private RadioGroup placeRadioGroup;
    private LinearLayout checkBoxLinearLayout;
    private Button moveLutemonsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);
        checkBoxLinearLayout = findViewById(R.id.checkBoxLinearLayout);
        makeCheckBoxes();
        placeRadioGroup = findViewById(R.id.placeRadioGroup);
        moveLutemonsButton = findViewById(R.id.moveLutemonsButton);
        moveLutemons();
    }

    public void makeCheckBoxes() {
        checkBoxLinearLayout.removeAllViews();
        CheckBox checkBox;
        for (Lutemon lutemon: Storage.getAllLutemons()) {
            checkBox = new CheckBox(this);
            checkBox.setText(lutemon.getName());
            checkBox.setId(lutemon.getId());
            checkBoxLinearLayout.addView(checkBox);
        }
    }

    public void moveLutemons() {
        moveLutemonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (placeRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.homeRadioButton:
                        moveLutemonsToHome();
                        break;
                    case R.id.trainingAreaRadioButton:
                        moveLutemonsToTrainingArea();
                        break;
                    case R.id.battlefieldRadioButton:
                        moveLutemonsToBattlefield();
                        break;
                }
                Intent showMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(showMainActivity);
            }
        });
    }

    public void moveLutemonsToHome() {
        CheckBox checkBox;
        ArrayList<Lutemon> lutemons = new ArrayList<>();
        for (Lutemon lutemon: BattleField.getInstance().getLutemons()) {
            checkBox = findViewById(lutemon.getId());
            if (checkBox.isChecked()) {
                lutemon.setHealth(lutemon.getMaxHealth());
                Home.getInstance().addLutemon(lutemon);
                lutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon: lutemons) {
            BattleField.getInstance().removeLutemon(lutemon);
        }
    }

    public void moveLutemonsToTrainingArea() {
        CheckBox checkBox;
        for (Lutemon lutemon: BattleField.getInstance().getLutemons()) {
            checkBox = findViewById(lutemon.getId());
            if (checkBox.isChecked()) {
                TrainingArea.getInstance().addLutemon(lutemon);
            }
        }
        for (Lutemon lutemon: Home.getInstance().getLutemons()) {
            checkBox = findViewById(lutemon.getId());
            if (checkBox.isChecked()) {
                TrainingArea.getInstance().addLutemon(lutemon);
            }
        }
        TrainingArea.getInstance().train();
        TrainingArea.getInstance().removeLutemons();
    }

    public void moveLutemonsToBattlefield() {
        CheckBox checkBox;
        ArrayList<Lutemon> lutemons = new ArrayList<>();
        for (Lutemon lutemon: Home.getInstance().getLutemons()) {
            checkBox = findViewById(lutemon.getId());
            if (checkBox.isChecked()) {
                BattleField.getInstance().addLutemon(lutemon);
                lutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon: lutemons) {
            Home.getInstance().removeLutemon(lutemon);
        }
    }
}