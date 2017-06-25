package com.example.geraldo.farra.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.Eventos;
import com.example.geraldo.farra.model.Ingresso;
import com.example.geraldo.farra.model.ItemDeCompra;

import java.util.List;

import static com.example.geraldo.farra.util.MyApp.getContext;

/**
 * Created by usuario on 24/06/2017.
 */

public class IngressoAdapter extends ArrayAdapter<ItemDeCompra> {
    private List<ItemDeCompra> items;

    public IngressoAdapter(Context context, int textViewResourceId, List<ItemDeCompra> items) {
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
        ItemDeCompra itemDeCompra = items.get(position);
        Log.i("Adapter", itemDeCompra.getIngresso().getEvento().getNomeEvento());
        if (itemDeCompra != null) {
            ((TextView) v.findViewById(R.id.lbNmEvento)).setText(itemDeCompra.getIngresso().getEvento().getNomeEvento());
            ((TextView) v.findViewById(R.id.lbLocal)).setText(itemDeCompra.getIngresso().getEvento().getEndereco());
            ((TextView) v.findViewById(R.id.lbData)).setText(itemDeCompra.getIngresso().getEvento() + ", " + itemDeCompra.getIngresso().getEvento().getHorario());
            //((ImageView) v.findViewById(R.id.imgCidade)).setImageResource(R.drawable.logo);
        }
        return v;
    }
}
