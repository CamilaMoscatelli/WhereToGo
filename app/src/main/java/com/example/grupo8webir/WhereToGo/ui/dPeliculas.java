package com.example.grupo8webir.WhereToGo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.grupo8webir.WhereToGo.R;

public class dPeliculas extends AppCompatActivity {
    Double lat;
    Double lon;
    //Datos del evento
    Integer mins = 0;
    String gen = "Algo";
    String titulo = "Titulo de la pelicula";
    String synopsis = "En 1926 New Scamander se prepara para iniciar una excursión por todo el mundo en busca de una extraordinaria variedad de criaturas mágicas. Al llegar a Nueva York, para hacer una breve escala, todo parece ir bien, hasta que un muggle llamado Jacob y la fuga de algunas bestias fantásticas de Newt, podrian representar un verdadero problema tanto para la comunidad mágica como para los muggles.";
    String duracion = "Duracion: " + mins + " minutos";
    String genero = "Genero: " + gen;
    //Datos de los shows, el primero se muestra por defecto
    String [] datosShows = {"Shows","show 1","show 2", "show 2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_peliculas);

        // Imagen del evento
        ImageView iv = (ImageView)  findViewById(R.id.pImagen);
        iv.setImageResource(R.drawable.animalesfantasticos); //imagen!
        // Titulo
        TextView tvTitulo = (TextView) findViewById(R.id.pTitulo);
        tvTitulo.setText(titulo);
        // Shows
        Spinner shows = (Spinner) findViewById(R.id.spinnerShows);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datosShows);
        shows.setAdapter(adaptador);
        // Synopsis
        TextView tvSynopsis= (TextView) findViewById(R.id.pSynopsis);
        tvSynopsis.setText(synopsis);
        tvSynopsis.setMovementMethod(new ScrollingMovementMethod());
        // Duracion
        TextView tvDuracion = (TextView) findViewById(R.id.pDuracion);
        tvDuracion.setText(duracion);
        // Genero
        TextView tvGenero = (TextView) findViewById(R.id.pGenero);
        tvGenero.setText(genero);


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
