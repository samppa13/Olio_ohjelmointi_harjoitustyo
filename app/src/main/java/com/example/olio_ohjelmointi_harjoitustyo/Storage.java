package com.example.olio_ohjelmointi_harjoitustyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public void removeLutemons() {
        lutemons.removeAll(lutemons);
    }

    public static ArrayList<Lutemon> getAllLutemons() {
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