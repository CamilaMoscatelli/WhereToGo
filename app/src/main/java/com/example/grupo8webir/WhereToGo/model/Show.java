package com.example.grupo8webir.WhereToGo.model;

/**
 * Created by Camila on 19/11/2016.
 */
public class Show {

    private String cinema_name;
    private String date_to_display;
    private String time_to_display;
    private Integer price_cents;

    public Show(String cinema_name, Integer price_cents, String time_to_display, String date_to_display) {
        this.cinema_name = cinema_name;
        this.price_cents = price_cents;
        this.time_to_display = time_to_display;
        this.date_to_display = date_to_display;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getDate_to_display() {
        return date_to_display;
    }

    public void setDate_to_display(String date_to_display) {
        this.date_to_display = date_to_display;
    }

    public String getTime_to_display() {
        return time_to_display;
    }

    public void setTime_to_display(String time_to_display) {
        this.time_to_display = time_to_display;
    }

    public Integer getPrice_cents() {
        return price_cents;
    }

    public void setPrice_cents(Integer price_cents) {
        this.price_cents = price_cents;
    }
}
