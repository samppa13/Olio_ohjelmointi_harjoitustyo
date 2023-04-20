package com.example.olio_ohjelmointi_harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListLutemonsActivity extends AppCompatActivity {

    private RecyclerView lutemonsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);
        lutemonsRecyclerView = findViewById(R.id.lutemonsRecyclerView);
        lutemonsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lutemonsRecyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), Storage.getInstance().getLutemons()));
    }
}