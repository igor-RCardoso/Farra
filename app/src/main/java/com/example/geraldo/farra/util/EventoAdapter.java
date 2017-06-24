package com.example.geraldo.farra.util;

/**
 * Created by Geraldo on 23/06/2017.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.Eventos;

public class EventoAdapter extends ArrayAdapter<Eventos> {
    private List<Eventos> items;

    public EventoAdapter(Context context, int textViewResourceId, List<Eventos> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            Context ctx = getContext();
            LayoutInflater vi = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.evento_lista_modelo, null);
        }
        Log.i("Adapter", "Chegou aqui");
        Eventos evento = items.get(position);
        if (evento != null) {
            ((TextView) v.findViewById(R.id.lbNmEvento)).setText(evento.getNomeEvento());
            ((TextView) v.findViewById(R.id.lbLocal)).setText(evento.getEndereco());
            ((TextView) v.findViewById(R.id.lbData)).setText(evento.getDataEvento() + ", " + evento.getHorario());
            //((ImageView) v.findViewById(R.id.imgCidade)).setImageResource(R.drawable.logo);
        }
        return v;
    }
}