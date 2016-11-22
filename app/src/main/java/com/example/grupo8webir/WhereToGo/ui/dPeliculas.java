package com.example.grupo8webir.WhereToGo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.grupo8webir.WhereToGo.R;

public class dPeliculas extends AppCompatActivity {
    Double lat;
    Double lon;
    //Datos de los shows, el primero se muestra por defecto
    String [] datosShows = {"Shows","show 1","show 2", "show 2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_peliculas);

        ImageView iv = (ImageView)  findViewById(R.id.pImagen);
        iv.setImageResource(R.drawable.animalesfantasticos);
        Spinner shows = (Spinner) findViewById(R.id.spinnerShows);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datosShows);
        shows.setAdapter(adaptador);

    }

    public void irAlMapa(View view){
        //Valores de prueba
        lat = -34.903131;
        lon = -56.136408;
        //Montevideo Shopping", -34.903131, -56.136408

        // Ir al mapa
        Intent intent = new Intent(this, MapActivity.class);
        Bundle b = new Bundle();
        b.putString("PLACE_NAME", "Montevideo Shopping");
        b.putDouble("PLACE_LAT", lat);
        b.putDouble("PLACE_LNG", lon);
        intent.putExtras(b);
        startActivity(intent);
    }
}
