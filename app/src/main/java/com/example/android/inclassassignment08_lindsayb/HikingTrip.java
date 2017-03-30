package com.example.android.inclassassignment08_lindsayb;

import java.io.Serializable;

public class HikingTrip implements Serializable {

    private String place;
    private int miles;
    private boolean beenThere;

    public HikingTrip(String place, int miles, boolean beenThere) {
        this.place = place;
        this.miles = miles;
        this.beenThere = beenThere;
    }

    public HikingTrip() {
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public boolean isBeenThere() {
        return beenThere;
    }

    public void setBeenThere(boolean beenThere) {
        this.beenThere = beenThere;
    }

    @Override
    public String toString() {
        return "Place: " + place + '\n' +
                "Miles: " + miles + '\n' +
                "I have been there: " + beenThere + "\n" + "\n";
    }


}