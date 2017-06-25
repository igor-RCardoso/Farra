package com.example.geraldo.farra.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.geraldo.farra.R;

public class EventoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] spin= new String[]{"Masculino", "Feminino", "Unissex"};
    private String sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        Spinner s = (Spinner)findViewById(R.id.spinner);
        s.setOnItemSelectedListener(this);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spin);
        s.setAdapter(adaptador);
    }

    @Override
    public void onItemSelected(AdapterView parent, View view, int position, long id) {
        sexo = spin[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
