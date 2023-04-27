package com.example.olio_ohjelmointi_harjoitustyo;

public class Lutemon {
    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int image;
    private static int idCounter = 0;

    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id, int image) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.image = image;
        idCounter++;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfCreatedLutemons() {
        return idCounter;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void defense(Lutemon lutemon) {
        int hit = lutemon.attack() - defense;
        setHealth(health - hit);
    }

    public int attack() {
        return attack + experience;
    }
}