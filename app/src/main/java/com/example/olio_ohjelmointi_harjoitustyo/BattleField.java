package com.example.olio_ohjelmointi_harjoitustyo;

import java.util.ArrayList;

public class BattleField extends Storage {
    private static BattleField battleField = null;

    private BattleField() {}

    public static BattleField getInstance() {
        if (battleField == null) {
            battleField = new  BattleField();
        }
        return battleField;
    }

    public String fight(ArrayList<Lutemon> twoLutemons) {
        Lutemon attacker = twoLutemons.get(0);
        Lutemon defender = twoLutemons.get(1);
        String summaryOfBattle = "";
        while (true) {
            summaryOfBattle += "Attacker: " + attacker.getColor() + "(" + attacker.getName() + ") "
                    + "att: " + attacker.getAttack() + " def: " + attacker.getDefense()
                    + " exp: " + attacker.getExperience()
                    + " health: " + attacker.getHealth() + "/" + attacker.getMaxHealth();
            summaryOfBattle += "\nDefender: " + defender.getColor() + "(" + defender.getName() + ") "
                    + "att: " + defender.getAttack() + " def: " + defender.getDefense()
                    + " exp: " + defender.getExperience()
                    + " health: " + defender.getHealth() + "/" + defender.getMaxHealth();
            summaryOfBattle += "\n" + attacker.getColor() + "(" + attacker.getName() + ") attacks "
                    + defender.getColor() + "(" + defender.getName() + ")";
            defender.defense(attacker);
            if (defender.getHealth() > 0) {
                summaryOfBattle += "\n" + defender.getColor() + "(" + defender.getName() + ") manage escape death.\n";
                if (twoLutemons.lastIndexOf(attacker) == 0 && twoLutemons.lastIndexOf(defender) == 1) {
                    attacker = twoLutemons.get(1);
                    defender = twoLutemons.get(0);
                }
                else {
                    attacker = twoLutemons.get(0);
                    defender = twoLutemons.get(1);
                }
            }
            else {
                summaryOfBattle += "\n" + defender.getColor() + "(" + defender.getName() + ") was defeated in battle.";
                attacker.setExperience(attacker.getExperience() + 1);
                attacker.setWins(attacker.getWins() + 1);
                defender.setExperience(0);
                defender.setHealth(defender.getMaxHealth());
                defender.setLosses(defender.getLosses() + 1);
                Home.getInstance().addLutemon(defender);
                removeLutemon(defender);
                summaryOfBattle += "\nThe battle is over.";
                break;
            }
        }
        return summaryOfBattle;
    }
}
