package com.example.grupo8webir.WhereToGo.model;

import java.util.List;

/**
 * Created by Camila on 23/10/2016.
 */
public class Event {

    private String title;
    private String synopsis;
    private String poster_url;
    private String trailer_url;
    private Integer duration;
    private String genre;
    private EventType type;
    private List<Show> shows;

    public Event(String title, EventType type, String genre, Integer duration, String trailer_url, String poster_url, String synopsis) {
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.duration = duration;
        this.trailer_url = trailer_url;
        this.poster_url = poster_url;
        this.synopsis = synopsis;
    }

    public Event(String title, String poster_url) {
        this.title = title;
        this.poster_url = poster_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public String getPoster_url() {
        return poster_url;
    }

    public void setPoster_url(String poster_url) {
        this.poster_url = poster_url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
