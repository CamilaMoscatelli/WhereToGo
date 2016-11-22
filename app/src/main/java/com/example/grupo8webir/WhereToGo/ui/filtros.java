package com.example.grupo8webir.WhereToGo.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.grupo8webir.WhereToGo.R;
import com.example.grupo8webir.WhereToGo.api.ComunicationManager;
import com.example.grupo8webir.WhereToGo.model.Event;
import com.example.grupo8webir.WhereToGo.utils.EventsHolder;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class filtros extends AppCompatActivity {
    SeekBar precio;
    Button fecha;
    Button horario;
    TextView fechaSelect;
    TextView precioSelect;
    TextView horaSelect;
    int anio,mes,dia, hora, minutos;
    String textohora, textominutos;
    static final int dialog_id = 0;
    static final int hora_id = 1;

    private static ProgressBar spinner;
    private static Integer eventsLoaded = 3;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);
        showDialogOnButtonClick();

        mContext = this;

        final Calendar fActual = Calendar.getInstance();
        anio = fActual.get(Calendar.YEAR);
        mes = fActual.get(Calendar.MONTH);
        dia = fActual.get(Calendar.DAY_OF_MONTH);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Filtros");

        spinner = (ProgressBar)findViewById(R.id.progressBar);

        precio = (SeekBar) findViewById(R.id.barraPrecio);
        precio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                precioSelect = (TextView) findViewById(R.id.precio);
                precioSelect.setText("$ " +progress );
            }

            /**
             * El usuario inicia la interacción con la Seekbar.
             */
            @Override
            public void onStartTrackingTouch(SeekBar arg0)
            {

            }

            /**
             * El usuario finaliza la interacción con la Seekbar.
             */
            @Override
            public void onStopTrackingTouch(SeekBar arg0)
            {

            }
        });
    }

    //Funciones fecha y hora
    public void showDialogOnButtonClick(){
        fecha = (Button) findViewById(R.id.botonFecha);
        fecha.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        showDialog(dialog_id);
                    }
                });
        horario = (Button) findViewById(R.id.botonHora);
        horario.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        showDialog(hora_id);
                    }
                });
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id == dialog_id){
            return new DatePickerDialog(this, dpickerListner, anio, mes, dia);
        }
        if(id == hora_id){
            return new TimePickerDialog(this, tpickerListner, hora, minutos, true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner =
            new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int d,int m, int a ){
                    anio =a;
                    mes = m+1;
                    dia = d;
                    //Mostrar fecha seleccionada
                    fechaSelect = (TextView)findViewById(R.id.mostrarFecha);
                    fechaSelect.setText(anio + "/"+ mes+ "/" + dia);
                }
            };
    private TimePickerDialog.OnTimeSetListener tpickerListner =
            new TimePickerDialog.OnTimeSetListener(){
                @Override
                public void onTimeSet(TimePicker view, int h, int m ){
                    hora = h;
                    minutos = m;
                    //Mostrar hora seleccionada
                    horaSelect = (TextView)findViewById(R.id.hora);
                    if (hora<10)
                        textohora = "0" + hora;
                    else
                        textohora = String.valueOf(hora);
                    if (minutos <10)
                        textominutos = "0" + minutos;
                    else
                        textominutos = String.valueOf(minutos);
                    horaSelect.setText(textohora + " : "+ textominutos);
                }
            };

    public void goToResults(View view){
        //TODO
        /*
        ArrayList<Event> eventList1 = new ArrayList<Event>();
        eventList1.add(new Event("Spiderman", "First Item on the list"));
        ArrayList<Event> eventList2 = new ArrayList<Event>();
        eventList2.add(new Event("Superman", "Second Item on the list"));
        ArrayList<Event> eventList3 = new ArrayList<Event>();
        eventList3.add(new Event("Batman", "Third Item on the list"));

        EventsHolder eventsHolder = EventsHolder.getInstance();
        eventsHolder.musicEvents = eventList1;
        eventsHolder.moviesEvents = eventList2;
        eventsHolder.theatreEvents = eventList3;

        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);*/
        spinner.setVisibility(View.VISIBLE);
        ComunicationManager cm = ComunicationManager.getInstance();
        cm.getMovies();
        cm.getConcerts();
        cm.getPlays();
    }

    public static void goToResultsIfLoaded(String fromEventType, ArrayList<Event> events) {
        EventsHolder eventsHolder = EventsHolder.getInstance();
        switch (fromEventType) {
            case "Movies":
                eventsHolder.moviesEvents = events;
                break;
            case "Music":
                eventsHolder.musicEvents = events;
                break;
            case "Theatre":
                eventsHolder.theatreEvents = events;
                break;
        }
        eventsLoaded--;
        if (eventsLoaded == 0) {
            eventsLoaded = 3;
            spinner.setVisibility(View.GONE);
            Intent intent = new Intent(mContext, ResultsActivity.class);
            mContext.startActivity(intent);
        }
    }
}
