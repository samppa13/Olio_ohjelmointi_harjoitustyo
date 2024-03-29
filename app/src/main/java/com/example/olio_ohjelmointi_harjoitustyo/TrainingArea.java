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

    public void train() {
        for (Lutemon lutemon: lutemons) {
            lutemon.setExperience(lutemon.getExperience() + 1);
            lutemon.setTrainingDays(lutemon.getTrainingDays() + 1);
        }
    }
}