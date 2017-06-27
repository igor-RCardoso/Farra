package com.example.geraldo.farra.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.ControladoraFachadaSingleton;

public class PagamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        ImageButton botaoImagem2 = (ImageButton) findViewById(R.id.imageButton);
        botaoImagem2.setImageResource(R.mipmap.back);
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
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        Log.i("olar",rg.getId()+"");
        Log.i("Pagamento","oi");
        if(rg.getCheckedRadioButtonId() == R.id.radioButton2) {
            Intent it2 = new Intent(this, CartaoCreditoActivity.class);
            it2.putExtra("lista",li);
            Log.i("Pagamento","oi1");
            startActivity(it2);
        } else if (rg.getCheckedRadioButtonId() == R.id.radioButton){
            Log.i("Pagamento","oi2");
            ControladoraFachadaSingleton.getOurInstance().comprarIngresso(ControladoraFachadaSingleton.getOurInstance().getUsuario(),
                    li.getListaIngresso(),li.getListaQtd(),li.getN());
            Toast.makeText(this,"Pagamento feito no boleto", Toast.LENGTH_SHORT).show();
        }
        Log.i("Pagamento","tchau");
        finish();
    }
}
