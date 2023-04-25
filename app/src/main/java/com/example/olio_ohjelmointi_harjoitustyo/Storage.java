package com.example.olio_ohjelmointi_harjoitustyo;

import java.util.ArrayList;

public abstract class Storage {
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();

    public Storage() {}

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }
}