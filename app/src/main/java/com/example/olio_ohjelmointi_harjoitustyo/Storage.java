package com.example.olio_ohjelmointi_harjoitustyo;

import java.util.ArrayList;

public class Storage {
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();
    protected static Storage storage = null;

    protected Storage() {}

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }
}