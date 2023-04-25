package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListLutemonsActivity extends AppCompatActivity {

    private RecyclerView lutemonsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);
        lutemonsRecyclerView = findViewById(R.id.lutemonsRecyclerView);
        lutemonsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lutemonsRecyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), getAllLutemons()));
    }

    public ArrayList<Lutemon> getAllLutemons() {
        ArrayList<Lutemon> allLutemons = new ArrayList<>();
        allLutemons.addAll(Home.getInstance().getLutemons());
        allLutemons.addAll(BattleField.getInstance().getLutemons());
        Collections.sort(allLutemons, new Comparator<Lutemon>() {
            @Override
            public int compare(Lutemon lutemon, Lutemon t1) {
                return String.valueOf(lutemon.getId()).compareTo(String.valueOf(t1.getId()));
            }
        });
        return allLutemons;
    }
}