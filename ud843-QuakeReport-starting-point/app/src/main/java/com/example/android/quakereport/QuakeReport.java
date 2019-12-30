package com.example.android.quakereport;


public class QuakeReport {
    private double scale;
    private String offset;
    private String city;
    private String time;
    private String url;

    public QuakeReport(double scale,String offset, String city, String time,String url)
    {
        this.city = city;
        this.scale = scale;
        this.offset = offset;
        this.time = time;
        this.url = url;

    }


    public String getOffset() {
        return offset;
    }

    public double getScale() {
        return scale;
    }

    public String getCity() {
        return city;
    }

    public String getTime() {
        return time;
    }

    public String getUrl() { return url;}
}
