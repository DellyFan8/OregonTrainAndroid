package com.example.myapplication.GameMech;

import java.util.ArrayList;

public class GameMechs {
    static int money;
    static ArrayList<Person> party;

    public static int getMoney() {
        return money;
    }

    public static void addMoney(int amount){
        GameMechs.money += amount;
    }
    public static void setMoney(int money) {
        GameMechs.money = money;
    }

    public static ArrayList<Person> getParty() {
        return party;
    }

    public static void setParty(ArrayList<Person> party) {
        GameMechs.party = party;
    }
}
