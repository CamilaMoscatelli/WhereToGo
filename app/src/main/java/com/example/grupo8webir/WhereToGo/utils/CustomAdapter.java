package com.example.grupo8webir.WhereToGo.utils;

import java.util.ArrayList;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.example.grupo8webir.WhereToGo.R;
import com.example.grupo8webir.WhereToGo.model.Event;

/**
 * Created by Camila on 13/11/2016.
 */

public class CustomAdapter extends ArrayAdapter<Event> {

    private final Context context;
    private final ArrayList<Event> itemsArrayList;

    public CustomAdapter(Context context, ArrayList<Event> itemsArrayList) {
        super(context, R.layout.results_row, itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.results_row, parent, false);

        // 3. Get the two text view from the rowView
        TextView nameView = (TextView) rowView.findViewById(R.id.eventName);
        TextView descriptionText = (TextView) rowView.findViewById(R.id.description);
        ImageView bannerView = (ImageView) rowView.findViewById(R.id.eventImage);

        // 4. Set the text for textView
        nameView.setText(itemsArrayList.get(position).getTitle());
        descriptionText.setText(itemsArrayList.get(position).getSynopsis());
        Picasso.with(this.getContext())
                .load(itemsArrayList.get(position).getPoster_url())
                .into(bannerView);

        // 5. return rowView
        return rowView;
    }
}