package com.example.geraldo.farra.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.ControladoraFachadaSingleton;

public class CartaoCreditoActivity extends AppCompatActivity {

    private String[] bandeiras = {"Mastercard","Elo","Visa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_credito);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,bandeiras);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adaptador);
    }

    public void pagar(View v) {
        Intent it = getIntent();
        ListaIngressos li = (ListaIngressos) it.getSerializableExtra("lista");
        ControladoraFachadaSingleton.getOurInstance().comprarIngresso(ControladoraFachadaSingleton.getOurInstance().getUsuario(),
                li.getListaIngresso(),li.getListaQtd(),li.getN());
        finish();
    }
}
