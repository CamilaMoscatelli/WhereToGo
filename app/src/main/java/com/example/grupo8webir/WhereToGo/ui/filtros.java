package com.example.grupo8webir.WhereToGo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.grupo8webir.WhereToGo.R;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

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

    //@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);
        showDialogOnButtonClick();
        final Calendar fActual = Calendar.getInstance();
        anio = fActual.get(Calendar.YEAR);
        mes = fActual.get(Calendar.MONTH);
        dia = fActual.get(Calendar.DAY_OF_MONTH);

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

    public void goToFilters(View view){
        //TODO
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
}
