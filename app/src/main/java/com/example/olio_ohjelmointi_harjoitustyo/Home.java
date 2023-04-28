package com.example.olio_ohjelmointi_harjoitustyo;

import java.util.ArrayList;

public class Home extends Storage {
    private static Home home = null;

    private Home() {}

    public static Home getInstance() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }

    public void createLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void setLutemons(ArrayList<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }
}
