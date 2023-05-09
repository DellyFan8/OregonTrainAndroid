package com.example.myapplication.GameMech;

import java.util.ArrayList;


//The GameMechs class stores the temporary information that needs passed between classes
public class GameMechs {
    static int money;
    static ArrayList<Person> party;

    public static Store getStore() {
        return store;
    }

    public static void setStore(Store store) {
        GameMechs.store = store;
    }

    static Store store;

    public static Inventory getInventory() {
        return inventory;
    }

    public static void setInventory(Inventory inventory) {
        GameMechs.inventory = inventory;
    }

    static Inventory inventory;

    public static int getDay() {
        return day;
    }

    public static void setDay(int day) {
        GameMechs.day = day;
    }

    static int day;

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
