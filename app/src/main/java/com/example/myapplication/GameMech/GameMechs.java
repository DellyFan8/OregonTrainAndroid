package com.example.myapplication.GameMech;

import java.util.ArrayList;


//The GameMechs class stores the temporary information that needs passed between classes
public class GameMechs {
    public static boolean getHaveStareted() {
        return haveStareted;
    }

    public static void setHaveStareted(boolean haveStareted) {
        GameMechs.haveStareted = haveStareted;
    }

    static boolean haveStareted;
    static int money;
    static ArrayList<Location> runnerLocations;
    static ArrayList<Person> party;

    public static Store getStore() {
        return store;
    }

    static Map map;

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        GameMechs.map = map;
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

    public void setLocations() {

        Event end= new Event(Event.EventType.END);

        //region Location Declaration

        //Declare location runner
        runnerLocations = new ArrayList<Location>();

        //Independence information
        runnerLocations.add(new Location(0,"Independence",new Store("Independence Wholesale", inventory,0), 1));

        //KR crossing information
        Event krCrossing = new Event(Event.EventType.RIVERCROSSING,1450.848,true);
        runnerLocations.add(new Location(102, "Kansas River crossing",krCrossing));

        //BBR crossing information
        Event bbrCrossing = new Event(Event.EventType.RIVERCROSSING,2072.64,false);
        runnerLocations.add(new Location(184,"Big Blue River Crossing",bbrCrossing));

        //Fort Kearny information
        runnerLocations.add(new Location(319,"Fort Kearny",new Store("Koo Koo Kearney's", inventory,1), 1.25));

        //Ash Hallow information
        runnerLocations.add(new Location(504,"Ash Hallow"));

        //Chimney rock information
        runnerLocations.add(new Location(554,"Chimney Rock"));

        //Scotts Bluff
        runnerLocations.add(new Location(596,"Scotts Bluff"));

        //Registar Cliff
        runnerLocations.add(new Location(658,"Register Cliff"));

        //Fort Laramie
        runnerLocations.add(new Location(750,"Fort Laramie",new Store("Laramie's Store", inventory,1), 1.5));

        //Independence Rock
        runnerLocations.add(new Location(815,"Independence Rock"));

        //South Pass
        Event split1=new Event(Event.EventType.SPLIT1);
        runnerLocations.add(new Location(914,"South Pass",split1));

//soda springs
        runnerLocations.add(new Location(1133,"Soda Springs"));
        //fort hall
        runnerLocations.add(new Location(1190,"Fort Hall",new Store("Hall's Store", inventory,1), 2));
        //snake river
        Event snCrossing = new Event(Event.EventType.RIVERCROSSING,1800,false);
        runnerLocations.add(new Location(1372,"Snake river Crossing",snCrossing));
        //Fort boise
        runnerLocations.add(new Location(1486,"Fort Boise",new Store("Boise's Store", inventory,1),2.25));

        runnerLocations.add(new Location(1642, "Blue mountain"));

        //Fort Bridger
        runnerLocations.add(new Location(1743,"Fort Walla Walla",new Store("Wally's Store", inventory,1), 1.75));
        //The dallas
        runnerLocations.add(new Location(1923,"The Dallas"));
        runnerLocations.add(new Location(2203,"The End",end));



        setMap(new Map(runnerLocations, inventory, day));
    }
}
