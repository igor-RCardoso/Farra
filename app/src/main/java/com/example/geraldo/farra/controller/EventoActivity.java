package com.example.geraldo.farra.controller;

import android.content.Intent;
import android.provider.BlockedNumberContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.ControladoraFachadaSingleton;
import com.example.geraldo.farra.model.Eventos;
import com.example.geraldo.farra.model.Ingresso;
import com.j256.ormlite.stmt.query.In;

import java.util.ArrayList;
import java.util.List;

public class EventoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] spin= new String[]{"Masculino", "Feminino", "Unissex"};
    private String sexo;
    private List<String> aux;
    private int loteSelecionado;
    private Eventos evento;
    private Ingresso ingresso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        Spinner s = (Spinner)findViewById(R.id.spinner);
        s.setOnItemSelectedListener(this);

        Intent it = getIntent();
        evento = (Eventos) it.getSerializableExtra("evento");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spin);
        s.setAdapter(adaptador);

        Log.i("olar","evento");
        Log.i("olar",evento.getIngressoCollection().size()+"evento");
        Log.i("olar","evento");

        TextView txLocalizacao = (TextView)findViewById(R.id.txLocalizacao);
        TextView txData = (TextView)findViewById(R.id.txDt);
        TextView txNm = (TextView)findViewById(R.id.txNmEvento);
        Spinner spLote = (Spinner)findViewById(R.id.spinnerLote);
        spLote.setOnItemSelectedListener(this);
        txNm.setText(evento.getNomeEvento());
        txLocalizacao.setText(evento.getEndereco());
        txData.setText(evento.getDataEvento() + ", " + evento.getHorario());
        s.setAdapter(adaptador);

        //Faz o spinner do lote até a 56
        aux = new ArrayList<String>();
        int i = 0;
        for(Ingresso a : evento.getIngressoCollection()){
            aux.add(a.getLote() + "");
        }
        ArrayAdapter<String> adaptadorLote = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, aux);
        spLote.setAdapter(adaptadorLote);



    }

    @Override
    public void onItemSelected(AdapterView parent, View view, int position, long id) {
        TextView preco = (TextView)findViewById(R.id.txPrecoIndividual);
         switch(parent.getId()) {
             case R.id.spinner:
                 sexo = spin[position];
                 Log.i("Adapter", "Aqui esta o sexo: " + id);
                 for(Ingresso a : evento.getIngressoCollection()){
                     if(a.getLote() == loteSelecionado && a.getSexo().equals(sexo)) {
                         preco.setText("R$" + a.getPreco());
                         ingresso = a;
                     }
                 }
                 break;

             case R.id.spinnerLote:  // code for second spinner
                 loteSelecionado = Integer.parseInt(aux.get(position));
                 Log.i("Adapter", "Aqui esta o Lote: " + loteSelecionado);
                 for(Ingresso a : evento.getIngressoCollection()){
                     if(a.getLote() == loteSelecionado && a.getSexo().equals(sexo)) {
                         preco.setText("R$" + a.getPreco());
                         ingresso = a;
                     }
                 }
                 break;
         }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void pagar(View v) {
        Ingresso[] vi = new Ingresso[1]; int[] qtds = new int[1];
        vi[0] = ingresso; qtds[0] = 1;
        ListaIngressos li = new ListaIngressos(vi,qtds,1);
        Intent it = new Intent(this,PagamentoActivity.class);
        it.putExtra("lista",li);
        startActivity(it);
        Log.i("olar","chegou aqui");
    }
}
