package com.example.olio_ohjelmointi_harjoitustyo;

public class TrainingArea extends Storage {
    private static TrainingArea trainingArea = null;

    private TrainingArea() {}

    public static TrainingArea getInstance() {
        if (trainingArea == null) {
            trainingArea = new TrainingArea();
        }
        return trainingArea;
    }

    public void removeLutemons() {
        lutemons.removeAll(lutemons);
    }

    public void train() {
        for (Lutemon lutemon: lutemons) {
            lutemon.setExperience(lutemon.getExperience() + 1);
        }
    }
}