package com.example.geraldo.farra.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.ItemDeCompra;

public class IngressoVirtualActivity extends AppCompatActivity {

    private ItemDeCompra item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresso_virtual);

        Intent it = getIntent();
        item = (ItemDeCompra) it.getSerializableExtra("item");



        TextView tvLocal = (TextView) findViewById(R.id.textViewLocalizacao);
        TextView tvHorario = (TextView) findViewById(R.id.textViewHorario);
        TextView tvInfo = (TextView) findViewById(R.id.textViewInfo);

        tvLocal.setText(item.getIngresso().getEvento().getEndereco());
        tvHorario.setText(item.getIngresso().getEvento().getHorario());
        tvInfo.setText(item.getIngresso().getLote() + "º lote - " + item.getIngresso().getSexo() + " " + item.getIngresso().getPreco());

    }

    public void fechar(View v) {
        finish();
    }
}
