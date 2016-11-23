package com.example.grupo8webir.WhereToGo.model;

/**
 * Created by Camila on 19/11/2016.
 */
public class Show {

    private String place;
    private String date_to_display;
    private String time_to_display;
    private Float lat;
    private Float longitud;
    private Integer price_cents;

    public Show(String place, String date_to_display, String time_to_display, Float lat, Float longitud, Integer price_cents) {
        this.place = place;
        this.date_to_display = date_to_display;
        this.time_to_display = time_to_display;
        this.lat = lat;
        this.longitud = longitud;
        this.price_cents = price_cents;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime_to_display() {
        return time_to_display;
    }

    public void setTime_to_display(String time_to_display) {
        this.time_to_display = time_to_display;
    }

    public String getDate_to_display() {
        return date_to_display;
    }

    public void setDate_to_display(String date_to_display) {
        this.date_to_display = date_to_display;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public Integer getPrice_cents() {
        return price_cents;
    }

    public void setPrice_cents(Integer price_cents) {
        this.price_cents = price_cents;
    }
}
