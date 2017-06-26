package com.example.geraldo.farra.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.ControladoraFachadaSingleton;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        ImageButton botaoImagem2 = (ImageButton) findViewById(R.id.imageButton);
//        botaoImagem2.setImageResource(R.mipmap.back);
        Intent it = getIntent();
        double preco = 0;
        ListaIngressos li = (ListaIngressos) it.getSerializableExtra("lista");
        for(int i = 0; i < li.getN(); i++) {
            preco += li.getListaIngresso()[i].getPreco() * li.getListaQtd()[i];
        }
        TextView tvpreco = (TextView) findViewById(R.id.textView3);
        tvpreco.setText(preco + "");
    }

    public void fechar(View v) {
        finish();
    }

    public void pagar(View v) {
        Intent it = getIntent();
        ListaIngressos li = (ListaIngressos) it.getSerializableExtra("lista");
        RadioGroup rg = (RadioGroup) v.findViewById(R.id.radioGroup);
        Log.i("olar",rg.getId()+"");
        if(rg.getCheckedRadioButtonId() == R.id.radioButton2) {
            Intent it2 = new Intent(this, CartaoCreditoActivity.class);
            it2.putExtra("lista",li);
            startActivity(it2);
        } else if (rg.getCheckedRadioButtonId() == R.id.radioButton){
            ControladoraFachadaSingleton.getOurInstance().comprarIngresso(ControladoraFachadaSingleton.getOurInstance().getUsuario(),
                    li.getListaIngresso(),li.getListaQtd(),li.getN());
        }
        finish();
    }
}
