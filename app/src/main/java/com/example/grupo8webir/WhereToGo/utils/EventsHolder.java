package com.example.grupo8webir.WhereToGo.utils;

import com.example.grupo8webir.WhereToGo.model.Event;

import java.util.ArrayList;

/**
 * Created by Camila on 21/11/2016.
 */
public class EventsHolder {

    private static EventsHolder sInstance = null;
    public ArrayList<Event> moviesEvents;
    public ArrayList<Event> musicEvents;
    public ArrayList<Event> theatreEvents;

    public static EventsHolder getInstance() {
        if (sInstance == null) {
            sInstance = new EventsHolder();
        }

        return sInstance;
    }
}
