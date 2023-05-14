package com.example.myapplication.GameMech;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class WeatherRegion {
    private final ArrayList<Weather> weather;
    private int startmilage;
    private int endmilage;


    public WeatherRegion(int startmilage, int endmilage) {
        this.startmilage = startmilage;
        this.endmilage = endmilage;
        ArrayList<Weather> weatherrunners = new ArrayList<>();
        for (int i = 0; i < 43; i++) {
            String tempaverage = "12";
            String tempmax = "25";
            String tempmin = "-8";
            String tempmedian = "4";
            String rainaverage = "4.3";
            String rainmax = "42";
            String rainmedian = "0";
            String rainzero = "48";

            Weather weatherrunner = new Weather(rainaverage, rainmax, rainmedian, rainzero, tempaverage, tempmax, tempmin, tempmedian);
            weatherrunners.add(weatherrunner);
        }
        this.weather = weatherrunners;
    }
    boolean inregion(int milage){
        return milage > startmilage && milage <= endmilage;

    }
    double setrain(int day){
        int week = day/7;
        return weather.get(week).getrain();
    }
    int settemp(int day){
        int week = day/7;
        return weather.get(week).gettemp();
    }
    @Override
    public String toString() {
        return "WeatherRegion{" +
                "weather=" + weather +
                ", startmilage=" + startmilage +
                ", endmilage=" + endmilage +
                '}';
    }
}
