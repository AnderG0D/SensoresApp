package com.example.sensoresobtener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Objeto para gestion de sensores
    private SensorManager sensorManager;
    //Para guardar listado de sensores
    ListView listView_sensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_sensores = findViewById(R.id.listView_sensores);

        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> deviceSensors =
                sensorManager.getSensorList(Sensor.TYPE_ALL);

        // Crear adaptador, elegir diseña y vincular con datos
        final ArrayAdapter<Sensor> adapter =
                new ArrayAdapter<Sensor>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        deviceSensors);

        // Asociar datos en el listView
        listView_sensores.setAdapter(adapter);






    }
}