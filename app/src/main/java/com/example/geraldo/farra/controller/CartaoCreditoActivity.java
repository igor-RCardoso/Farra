package com.example.geraldo.farra.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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


        Log.i("Pagamento","oiCartao");
        Intent it = getIntent();
        Log.i("Pagamento","oiCartao1");
        double preco = 0;
        ListaIngressos li = (ListaIngressos) it.getSerializableExtra("lista");
        for(int i = 0; i < li.getN(); i++) {
            preco += li.getListaIngresso()[i].getPreco() * li.getListaQtd()[i];
        }
        TextView tvpreco = (TextView) findViewById(R.id.textViewPreco);
        tvpreco.setText(preco + "");
    }

    public void pagar(View v) {
        Intent it = getIntent();
        ListaIngressos li = (ListaIngressos) it.getSerializableExtra("lista");
        ControladoraFachadaSingleton.getOurInstance().comprarIngresso(ControladoraFachadaSingleton.getOurInstance().getUsuario(),
                li.getListaIngresso(),li.getListaQtd(),li.getN());

        Toast.makeText(this,"Pagamento feito no cartão", Toast.LENGTH_SHORT).show();
        finish();
    }
}
