package com.example.myapplication.GameMech;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import java.io.*;
import java.util.Random;

import static java.lang.System.out;

import com.example.myapplication.R;

//I think we should probably have a map class
public class Map {
    public static void main(String[] args){
//region this shouldnt be here
//        //series of locations for testing
//        ArrayList<Location> runnerLocations = new ArrayList<>();
//
//        //Insert location adding loop at some point when aaron is Good
//        runnerLocations.add(new Location(0,"location0"));
//        runnerLocations.add(new Location(1000,"Location1"));
//        runnerLocations.add(new Location(2000,"location2"));
//        runnerLocations.add(new Location(2500, "Special event crossing river"));//special event
//int day=0;
//        Map trail = new Map(runnerLocations, day);
//
//        //jerk
//        out.println(trail.toString());
//        out.println("");
//        out.println(trail.closestloc());
        //endregion
    }

        private int pace=3;
        private int rations=3;
        private final ArrayList<Location> locations;
        private final ArrayList<WeatherRegion> weatherregion= new ArrayList<>();
        private int playerdistance=0;
        private int waterTableincrease=0;
        private int daynumber;//to deal with weather events, possibly add days depending on what month is picked and then subtract that at the end when displaying how long of a trip you had.
        private double dayrain;
        private int daytemp;
        private final int startnumber;
        private final ArrayList<String> notification = new ArrayList<>();
        private Inventory playerinventory;


        public Map(ArrayList<Location> locations, Inventory inventory, int day) {
            this.locations = locations;
            this.daynumber=day;
            this.startnumber=day;
            this.playerinventory = inventory;
            weatherregion.add(new WeatherRegion(0,319));
            weatherregion.add(new WeatherRegion(319,750));
            weatherregion.add(new WeatherRegion(750,1190));
            weatherregion.add(new WeatherRegion(1190,1642));
            weatherregion.add(new WeatherRegion(1642,2000));
        }

    public Inventory getPlayerinventory() {
        return playerinventory;
    }

    public int distanceto(Location target){
            return target.getMilesinfromstart()-playerdistance;

        }

        public int getPlayerdistance() {
        return playerdistance;
    }

        public void setPace(int pace) {
            this.pace = pace;
        }

        public void setRations(int rations) {
            this.rations = rations;
        }

        public int getPace() {
            return pace;
        }

        public int getWaterTableincrease() {
            return waterTableincrease;
        }

        public int getRations() {
            return rations;
        }

    //default to next location.
        public int distanceto(){
            return distanceto(closestloc());
        }
        public Location closestloc() {
            for (Location loc : locations) {
                if (loc.getMilesinfromstart() >= playerdistance) {
                    return loc;
                }
            }
            return locations.get(locations.size()-1);
        }

        //advance the day,
        public int advanceDay() {
            int dist = dailyDistanceTravelled();
            int distanceToNextLocation = distanceto(closestloc());
            setRainandTemp();
            sicknesshandler();
            checkforloss();
            consumefood();
            if(distanceToNextLocation<dist && distanceToNextLocation!= 0){
                playerdistance+=distanceToNextLocation;
                daynumber++;

                //needs to be done separately
                return distanceToNextLocation;
            }
            else {
                playerdistance += dist;
                daynumber++;
                return dist;
            }

        }

        //handling if user decides to wait somewhere, not implemented elsewhere but may be eventually
        public int advanceDay(boolean dayadvance) {
            int dist = dailyDistanceTravelled();
            int distanceToNextLocation = distanceto(closestloc());
            setRainandTemp();
            sicknesshandler();
            consumefood();
            checkforloss();
            if(distanceToNextLocation<dist && distanceToNextLocation!= 0){
                daynumber++;

                //needs to be done separately
                return 0;
            }
            else {
                daynumber++;
                return 0;
            }

        }
        public void setRainandTemp(){
            this.waterTableincrease+=this.dayrain*2;
            this.dayrain= weatherregion.get(findregion()).setrain(this.daynumber);
            this.daytemp= weatherregion.get(findregion()).settemp(this.daynumber);
            if (waterTableincrease>0)
                this.waterTableincrease= (int) (this.waterTableincrease-((0.4*this.waterTableincrease)+2));
            else
                this.waterTableincrease=0;
        }

        public double gettemp(){
            return daytemp;
        }


        public double getrain(){
            return dayrain;
        }


    //add a notification to be displayed
        public void addnoti(String runnernotification){
            notification.add(runnernotification);
        }

        //Clear all notifications
        public void clearnoti(){
            for (int i = notification.size(); i > 0; i--) {
                notification.remove(0);
            }
        }
        public void hunt(){
            if(playerinventory.getBullets()>0) {
                Random rand = new Random();
                int rationsadd = rand.nextInt(50) + 30;
                playerinventory.removeBullets(5);
                playerinventory.add(new Food(Food.Type.RATIONS, "Rations", rationsadd, false));

                addnoti(rationsadd + " Rations were added to Inventory");
            }
            else{
                addnoti("No bullets to hunt with.");
            }

        }

        //Get a notification from an index
        public String getnoti(int index){
            return notification.get(index);
        }
        public int getDayNumber(){
            return daynumber;
        }

    //Calculating miles travelled on a given day
    public int dailyDistanceTravelled(){
        Random rand = new Random();
        int distancetravelled;
        distancetravelled=(pace*5);
        if (this.rations>3)
            distancetravelled+=rand.nextInt(4);
        else if (this.rations<3)
            distancetravelled-=rand.nextInt(2);
        if(playerinventory.getWeight()>1000)          //I have no clue what the expected weight will be
            distancetravelled-=10;
        if(pace<=2)distancetravelled+=3;
        return (int)((distancetravelled* (.75+(.25)*rand.nextDouble())+2));

        }
//    Legacy funtion:
//    public void dayDisplay(){
//        //display day related information every time a day advances
//        // record names of places entered, rivers crossed etc
//
//
//        out.println("Day "+(daynumber-startnumber)+", "+toDate()+":"); //plus one so we don't get "April 1st day 0:"
//        if (notification.size()!=0){
//            for (int i = 0; i <notification.size() ; i++) {
//                out.println(getnoti(i));
//            }
//        }
//
//        out.println("Daily log of injuries, illnesses, events, etc. goes here");
//        clearnoti();
//
//    }

    //display what events happened that day
        public String dayDisplay(int distanceTravelled){
        //display day related information every time a day advances
        // record names of places entered, rivers crossed etc

        //Use we or you?
            String display = "";

           display+=("Today you travelled "+ distanceTravelled+" miles.\n");




        if (notification.size()!=0){
               for (int i = 0; i <notification.size() ; i++) {
                   display+=(getnoti(i)+"\n");
               }
           }

           clearnoti();
           return display;

    }

        public void RandomEvent() {
        int randNum = (int) (Math.random() * 100);
        if (randNum >= 0 && randNum <= 1) { // lose trail(2.0%), call event class
            notification.add("Trail lost, you lose two days.");
            advanceDay(false);
            advanceDay(false);
        }
        else if (randNum == 2) {
            notification.add("Wrong trail, you lose one day.");
            advanceDay(false);
        }
        else if (randNum >= 3 && randNum <= 4) {
            // thief comes during night (2.0%), call event class
            //eventually will steal items from your inventory
        }
        else if (randNum >= 5 && randNum <= 8) {
            notification.add("You found wild berries! Plus 30 rations.");
            playerinventory.add(new Food(Food.Type.RATIONS,"Rations",30,false));
        }
    }

    public void addloc(Location runner){
            locations.add(runner);
    }
        public void sicknesshandler(){
            for (Person person: playerinventory.getPeopleinparty()) {
                Effect acted = person.randomsickness(this.rations);
                if (acted!=null){
                    if (person.getHealth()>0)
                        addnoti(person.getName()+" got sick with "+acted.sicknessName()+".");

                } else if (acted == null) {
                    Random rand = new Random();
                    if (rand.nextInt(4)==2){
                        person.increasehealth(5);
                        if (person.getHealth()==40&&person.getEffects().size()>0){
                            addnoti(person.getName()+" recovered from "+person.getEffects().get(0).sicknessName()+".");
                            person.removeEffect(0);
                        }
                    }
                }
            }
            checkfordead();

        }

        public void outOfFood(){
            for(Person person:playerinventory.getPeopleinparty()){
                person.decreaseHealth(5);
            }
        }

        public int sicknessRecovery(String name, int health) {
            if (health != 40) {
                if (health >= 35) {
                    int newHealth = 40;
                    String healthNoti = " has fully recovered.";
                    recoveryNoti(name, healthNoti, newHealth);
                    return newHealth;
                }
                else {
                    int newHealth = health + 5;
                    String healthNoti = " has recovered some.";
                    recoveryNoti(name, healthNoti, newHealth);
                    return newHealth;
                }
            }
            else { return health; }
    }

        public void sicknessNoti(String name, String healthNotification, String type, int health) {
            if (Objects.equals(healthNotification, " has died from ")) {
                notification.add(name + healthNotification + type + ".");
            }
            else {
                notification.add(name + healthNotification + type + ". Their health is now " + health + "/40.");
            }
    }

        public void recoveryNoti(String name, String healthNotification, int health) {
            notification.add(name + healthNotification + " Their health is now " + health + "/40.");
    }

    //A classic to string


    @Override
    public String toString() {
        return "Map{" +
                "locations=" + locations +
                ", weatherregion=" + weatherregion +
                ", playerdistance=" + playerdistance +
                ", startnumber=" + startnumber +
                '}';
    }

    //Funtion to take date current day count and return a formatted string
        public String toDate() {
            int numdate= this.daynumber;
            LocalDate date = LocalDate.of(1850, 3, 1).plusDays(numdate);
            return date.format(DateTimeFormatter.ofPattern("MMMM d")); // format as "MonthName day"
    }

        //Functing to display the date
        public String datedisplay(){
        String date = "Day "+(daynumber-startnumber+1)+", "+toDate()+":";
        return date;
    }
        //A terrible funtion to wait
        static void wait(int ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
        public int findregion(){
            int i = 0;
            for (WeatherRegion region: this.weatherregion) {
                if (region.inregion(this.playerdistance)){return i;}
                i++;
            }
            //if this ever gets returned, it is time to panic
            return 0;
    }
        public String weatherString(){
            String stringname= "";
            int temp = (this.daytemp)+32;
            stringname= stringname+temp+" and ";
            if (this.dayrain==0) {
                Random rand = new Random();
                if (rand.nextInt(10)>4)
                    return stringname + "Sunny.";
                return stringname+ "Cloudy";
            } else {
                if(this.daytemp>0) return stringname+"Rainy.";
                else return stringname+"Snowy.";
            }
        }
    //may eventually make a file to save scores to. Actually may literally make it rn because that sounds fun. unlike all this other stuff ive done
    boolean checkforloss(){
            //addmore ways to lose?
            if (playerinventory.personcount()==0){
                endGame();
                return true;
            }
            if (playerinventory.getRations()<=-10) {
                endGame();
                return true;
            }




            return false;
    }
    //Iterate through players and remove anyone that should be dead, just slap anywhere that may need it
    void checkfordead(){
            //health below or at 0
            //3 sicknesses
            ArrayList<Person> deadRunner=new ArrayList<>();
            for(Person person:playerinventory.getPeopleinparty()){
                if (person.getHealth()<=0)
                    deadRunner.add(person);
                if (person.getEffects().size()>=3)
                    deadRunner.add(person);
            }

            if(!deadRunner.isEmpty()) {
                for (Person person : deadRunner) {
                    playerinventory.getPeopleinparty().remove(person);
                    if (person.getEffects().size()==0) {
                        addnoti(person.getName()+" has died from starvation");

                    }
                    else{
                        addnoti(person.getName()+" has died from "+person.getEffects().get(0).sicknessName());
                    }
                }
            }
    }
    public void consumefood(){
            int consumedfoobar = 0;
            GameMechs gameMechs = new GameMechs();
            //Can adjust this formula
            consumedfoobar+= (int) (rations*2+3);
            if(playerinventory.getRations()-consumedfoobar<0){
                playerinventory.removeItems(new Food(Food.Type.RATIONS,"Rations",playerinventory.getRations(),false));
                addnoti("You are out of food!");
                outOfFood();
            }
            else{
                playerinventory.removeItems(new Food(Food.Type.RATIONS,"Rations",consumedfoobar,false));

                if(playerinventory.getRations()<consumedfoobar*2){
                    addnoti("You are low on food.");
                }
            }



    }

    public void endGame(){
            if (playerinventory.personcount()==0){
                out.println("You lost the game");
            }
            out.println("you lost the game");


    }

    //Hopefully unbreak river
    public void incdist(){
            this.playerdistance++;
    }

}
