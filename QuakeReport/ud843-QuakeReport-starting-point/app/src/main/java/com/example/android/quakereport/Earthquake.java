package com.example.android.quakereport;

public class Earthquake {

    private String url, location, date;
    private double magnitude;
    public Earthquake(double magnitude, String location, String date, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }


    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }


    public String getUrl() {
        return url;
    }

}
