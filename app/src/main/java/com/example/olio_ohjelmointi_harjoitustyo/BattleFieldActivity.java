package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BattleFieldActivity extends AppCompatActivity {
    private LinearLayout checkBoxesLinearLayout;
    private Button fightButton;
    private TextView summaryOfBattleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_field);
        checkBoxesLinearLayout = findViewById(R.id.checkBoxesLinearLayout);
        makeCheckBoxes();
        fightButton = findViewById(R.id.fightButton);
        fight();
        summaryOfBattleTextView = findViewById(R.id.summaryOfBattleTextView);
    }

    public void makeCheckBoxes() {
        checkBoxesLinearLayout.removeAllViews();
        CheckBox checkBox;
        for (Lutemon lutemon: BattleField.getInstance().getLutemons()) {
            checkBox = new CheckBox(this);
            checkBox.setText(lutemon.getName());
            checkBox.setId(lutemon.getId());
            checkBoxesLinearLayout.addView(checkBox);
        }
    }

    public void fight() {
        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Lutemon> twoLutemons = selectTwoLutemons();
                if (twoLutemons.size() != 2) {
                    Toast.makeText(getApplicationContext(), "Valitse kaksi Lutenomia!", Toast.LENGTH_LONG).show();
                    makeCheckedToFalse(twoLutemons);
                    return;
                }
                String summaryOfBattle = BattleField.getInstance().fight(twoLutemons);
                summaryOfBattleTextView.setText(summaryOfBattle);
                makeCheckedToFalse(twoLutemons);
                makeCheckBoxes();
            }
        });
    }

    public ArrayList<Lutemon> selectTwoLutemons() {
        CheckBox checkBox;
        ArrayList<Lutemon> twoLutemons = new ArrayList<>();
        for (Lutemon lutemon: BattleField.getInstance().getLutemons()) {
            checkBox = findViewById(lutemon.getId());
            if (checkBox.isChecked()) {
                twoLutemons.add(lutemon);
            }
        }
        return twoLutemons;
    }

    public void makeCheckedToFalse(ArrayList<Lutemon> lutemons) {
        CheckBox checkBox;
        for (Lutemon lutemon: lutemons) {
            checkBox = findViewById(lutemon.getId());
            checkBox.setChecked(false);
        }
    }
}