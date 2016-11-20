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

public class TabFragment extends Fragment {

    private static CustomAdapter adapter;
    private Integer tabPosition;
    private ArrayList<Event> eventList = new ArrayList<Event>();

    public static TabFragment newInstance(int tab) {
        TabFragment myFragment = new TabFragment();
        myFragment.tabPosition = tab;

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         //Pass context and data to the custom adapter
        CustomAdapter adapter = new CustomAdapter(getContext(), getEventsForTab(tabPosition));

        //Fragment view
        View view = inflater.inflate(R.layout.tabs, container, false);

        //Get ListView from activity_main.xml
        ListView listView = (ListView) view.findViewById(R.id.resultsListView);

        // Set ListAdapter
        listView.setAdapter(adapter);
        this.adapter = adapter;

        return view;
    }

    private ArrayList<Event> getEventsForTab(Integer tab) {
        switch (tab) {
            case 0:
                ComunicationManager.getInstance().getMovies();
                break;
            case 1:
                eventList.add(new Event("Spiderman","Second Item on the list"));
                break;
            case 2:
                eventList.add(new Event("Superman", "Third Item on the list"));
                break;
        }

        return eventList;
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
