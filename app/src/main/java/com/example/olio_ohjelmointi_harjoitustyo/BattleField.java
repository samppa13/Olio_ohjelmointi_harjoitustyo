package com.example.olio_ohjelmointi_harjoitustyo;

public class BattleField extends Storage {
    private static BattleField battleField = null;

    private BattleField() {}

    public static BattleField getInstance() {
        if (battleField == null) {
            battleField = new  BattleField();
        }
        return battleField;
    }
}
