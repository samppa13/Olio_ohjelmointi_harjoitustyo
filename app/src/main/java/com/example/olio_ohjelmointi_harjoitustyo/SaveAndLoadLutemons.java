package com.example.olio_ohjelmointi_harjoitustyo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveAndLoadLutemons {
    private static SaveAndLoadLutemons saveAndLoadLutemons = null;

    private SaveAndLoadLutemons() {}

    public static SaveAndLoadLutemons getInstance() {
        if (saveAndLoadLutemons == null) {
            saveAndLoadLutemons = new SaveAndLoadLutemons();
        }
        return saveAndLoadLutemons;
    }

    public void saveLutemons(Context context) {
        String fileName = "lutemons.txt";
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            ArrayList<Lutemon> lutemons = Storage.getAllLutemons();
            for (Lutemon lutemon: lutemons) {
                lutemon.setHealth(lutemon.getMaxHealth());
            }
            objectOutputStream.writeObject(lutemons);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLutemons(Context context) {
        String fileName = "lutemons.txt";
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            BattleField.getInstance().removeLutemons();
            ArrayList<Lutemon> lutemons = (ArrayList<Lutemon>) objectInputStream.readObject();
            Lutemon.setNumberOfCreatedLutemons(lutemons.size());
            Home.getInstance().setLutemons(lutemons);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
