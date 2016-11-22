package com.example.grupo8webir.WhereToGo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.grupo8webir.WhereToGo.model.Event;

import java.util.ArrayList;

/**
 * Created by Camila on 13/11/2016.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Event> musicEvents = new ArrayList<Event>();
    private ArrayList<Event> moviesEvents = new ArrayList<Event>();
    private ArrayList<Event> theatreEvents = new ArrayList<Event>();

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Event> moviesEvents,ArrayList<Event> musicEvents, ArrayList<Event> theatreEvents) {
        super(fm);
        this.musicEvents = musicEvents;
        this.moviesEvents = moviesEvents;
        this.theatreEvents = theatreEvents;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                //TODO
                return TabFragmentTheatre.newInstance(theatreEvents);
            case 2:
                //TODO
                return TabFragmentMusic.newInstance(musicEvents);
            default:
                return TabFragmentMovies.newInstance(moviesEvents);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
