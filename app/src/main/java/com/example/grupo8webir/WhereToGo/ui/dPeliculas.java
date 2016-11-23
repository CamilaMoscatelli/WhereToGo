package com.example.grupo8webir.WhereToGo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.grupo8webir.WhereToGo.R;
import com.example.grupo8webir.WhereToGo.model.Event;
import com.example.grupo8webir.WhereToGo.model.Show;
import com.example.grupo8webir.WhereToGo.utils.EventsHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class dPeliculas extends AppCompatActivity {
    Float lat;
    Float lon;
    //Datos del evento
    Integer mins = 0;
    String gen = "Algo";
    String titulo = "Titulo de la pelicula";
    String synopsis = "En 1926 New Scamander se prepara para iniciar una excursión por todo el mundo en busca de una extraordinaria variedad de criaturas mágicas. Al llegar a Nueva York, para hacer una breve escala, todo parece ir bien, hasta que un muggle llamado Jacob y la fuga de algunas bestias fantásticas de Newt, podrian representar un verdadero problema tanto para la comunidad mágica como para los muggles.";
    String duracion = "Duracion: " + mins + " minutos";
    String genero = "Genero: " + gen;
    Spinner shows;
    List<Show> showsList;
    ArrayList<String> datosShows = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_peliculas);

        //Put data
        EventsHolder eventsHolder = EventsHolder.getInstance();
        Event selectedEvent = eventsHolder.selectedEvent;
        showsList = selectedEvent.getShows();

        // Imagen del evento
        ImageView iv = (ImageView)  findViewById(R.id.pImagen);
        Picasso.with(this)
                .load(selectedEvent.getPoster_url())
                .into(iv);

        // Titulo
        TextView tvTitulo = (TextView) findViewById(R.id.pTitulo);
        tvTitulo.setText(selectedEvent.getTitle());

        // Shows
        shows = (Spinner) findViewById(R.id.spinnerShows);
        for (Show show : selectedEvent.getShows()) {
            datosShows.add(show.getPlace() + " " + show.getTime_to_display());
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,datosShows);
        shows.setAdapter(adaptador);

        // Synopsis
        TextView tvSynopsis= (TextView) findViewById(R.id.pSynopsis);
        tvSynopsis.setText(selectedEvent.getSynopsis());
        tvSynopsis.setMovementMethod(new ScrollingMovementMethod());

        // Duracion
        TextView tvDuracion = (TextView) findViewById(R.id.pDuracion);
        if (!selectedEvent.getShows().isEmpty()) {
            tvDuracion.setText("$ " + (selectedEvent.getShows().get(0).getPrice_cents() / 100));
        }

        // Genero
        TextView tvGenero = (TextView) findViewById(R.id.pGenero);
        //TODO tvGenero.setText(genero);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(selectedEvent.getTitle());
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something you want
                finish();
            }
        });
    }

    public void irAlMapa(View view){
        //Montevideo Shopping", -34.903131, -56.136408
        Integer showPosition = shows.getSelectedItemPosition();
        lat = showsList.get(showPosition).getLat();
        lon = showsList.get(showPosition).getLongitud();
        String placeName = showsList.get(showPosition).getPlace();

        // Ir al mapa
        Intent intent = new Intent(this, MapActivity.class);
        Bundle b = new Bundle();
        b.putString("PLACE_NAME", placeName);
        b.putDouble("PLACE_LAT", lat);
        b.putDouble("PLACE_LNG", lon);
        intent.putExtras(b);
        startActivity(intent);
    }
}
