package com.example.geraldo.farra.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.geraldo.farra.R;
import com.example.geraldo.farra.model.ControladoraFachadaSingleton;
import com.example.geraldo.farra.model.Eventos;
import com.example.geraldo.farra.model.Ingresso;
import com.example.geraldo.farra.model.ItemDeCompra;
import com.example.geraldo.farra.util.IngressoAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeusIngressosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_ingressos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ControladoraFachadaSingleton cg = ControladoraFachadaSingleton.getOurInstance();
        ListView lstResultados = (ListView) findViewById(R.id.lstIngressos);

        List<ItemDeCompra> list;
        if (cg.getUsuario().getItemDeCompraCollection() instanceof List)
            list = (List)cg.getUsuario().getItemDeCompraCollection();
        else
            list = new ArrayList(cg.getUsuario().getItemDeCompraCollection());


//        try {
//            //Ingresso i = cg.pegaIngresso(list.get(0).getIngresso().getId());
//            Log.i("Adapter", i.getEvento().getNomeEvento());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //List<Eventos> eventos = cg.getEventos();

//        try {
//            Ingresso ing = cg.getIngresso();
//            Log.i("Adapter", ing.getEvento().getNomeEvento());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        if(list.get(0).getIngresso().getEvento() == null){
            Log.i("Adapter", "Esta vazia " + list.get(0).getIngresso().getId());
        }else{
            Log.i("Adapter", "Nao Vazia " + list.get(0).getIngresso());
        }

        final IngressoAdapter adapter =
                new IngressoAdapter(getBaseContext(), R.layout.ingresso_lista_modelo, list);
        lstResultados.setAdapter(adapter);

        lstResultados.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                ItemDeCompra item = adapter.getItem(position);
                Log.e("olar",item.getId()+"");
                Intent it = new Intent(getBaseContext(), IngressoVirtualActivity.class);
                it.putExtra("item", item);
                startActivity(it);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meus_ingressos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent it = new Intent(getBaseContext(), PrincipalUsuarioActivity.class);
            startActivity(it);
            finish();
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
