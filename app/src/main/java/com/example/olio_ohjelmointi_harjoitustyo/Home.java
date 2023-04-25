package com.example.olio_ohjelmointi_harjoitustyo;

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
}
