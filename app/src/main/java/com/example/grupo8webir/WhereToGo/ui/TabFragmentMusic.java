package com.example.grupo8webir.WhereToGo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.grupo8webir.WhereToGo.R;
import com.example.grupo8webir.WhereToGo.api.ComunicationManager;
import com.example.grupo8webir.WhereToGo.model.Event;
import com.example.grupo8webir.WhereToGo.utils.CustomAdapter;


import java.util.ArrayList;

/**
 * Created by Camila on 13/11/2016.
 */

public class TabFragmentMusic extends Fragment {

    private static CustomAdapter adapter;
    private ArrayList<Event> musicEvents = new ArrayList<Event>();

    public static TabFragmentMusic newInstance(ArrayList<Event> musicEvents) {
        TabFragmentMusic myFragment = new TabFragmentMusic();
        myFragment.init(musicEvents);

        return myFragment;
    }

    public void init(ArrayList<Event> list) {
        this.musicEvents = list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Pass context and data to the custom adapter
        CustomAdapter adapter = new CustomAdapter(getContext(), musicEvents);

        //Fragment view
        View view = inflater.inflate(R.layout.tabs, container, false);

        //Get ListView from activity_main.xml
        ListView listView = (ListView) view.findViewById(R.id.resultsListView);

        // Set ListAdapter
        listView.setAdapter(adapter);
        this.adapter = adapter;

        return view;
    }

    //TODO check
    public static void reloadData(ArrayList<Event> events) {
        // update data in our adapter
        adapter.clear();
        adapter.addAll(events);
        // fire the event
        adapter.notifyDataSetChanged();
    }
}