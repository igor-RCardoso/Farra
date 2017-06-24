package com.example.geraldo.farra.model;

import android.nfc.Tag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geraldo on 22/06/2017.
 */

public class ControladoraFachadaSingleton implements Serializable{
    Usuario usuario;

    private static final ControladoraFachadaSingleton ourInstance = new ControladoraFachadaSingleton();

    public static ControladoraFachadaSingleton getInstance() {
        return ourInstance;
    }

    private ControladoraFachadaSingleton() {
    }

    private void primeiraVez(){
        List<Organizador> organizadores;
        List<CompraVenda> compraVendas;
        List<Eventos> eventos;
        List<Ingresso> ingressos;
        List<ItemDeCompra> itemDeCompras;
        List<Tags> tags;
        List<Usuario> usuarios;


        Eventos evento1 = new Eventos(1, "Quintaneja", "Viçosa", "16:00", "26/07/2017", 14, "Sertanejo", "Velho Oeste");
        Eventos evento2 = new Eventos(2, "Aniversário do Igor", "Viçosa", "22:00", "26/09/2017", 18, "Funk", "Favela");
        Eventos evento3 = new Eventos(3, "Aniversário do Fábio", "Rio Grande do Sul", "24:00", "24/04/2024", 21, "Liberdade", "Arco Iris");
        Eventos evento4 = new Eventos(4, "Quintaneja", "Viçosa", "16:00", "03/08/2017", 14, "Sertanejo", "Goias");
        Eventos evento5 = new Eventos(5, "Rockzera", "Porto Firme", "12:00", "02/01/2018", 14, "Rock", "Metal");
        Eventos evento6 = new Eventos(6, "Aniversário do Julio", "Rio Grande do Sul", "24:00", "24/04/2024", 21, "Liberdade", "Arco Iris");

        Organizador organizador2;
        Organizador organizador3;

        CompraVenda compraVenda1;
        CompraVenda compraVenda2;
        CompraVenda compraVenda3;

        Ingresso ingresso1;
        Ingresso ingresso2;
        Ingresso ingresso3;


        ItemDeCompra itemDeCompra1;
        ItemDeCompra itemDeCompra2;
        ItemDeCompra itemDeCompra3;

        Usuario usuario1;

        //Tags Esta pronto
        Tags tag1 = new Tags(1, "OpenBar", "Bebida liberada", evento1);
        Tags tag2 = new Tags(2, "OpenFood", "Comida liberada", evento2);
        Tags tag3 = new Tags(3, "Fantasia", "Venha fantasiado", evento3);
        Tags tag4 = new Tags(4, "Fantasia", "Venha fantasiado", evento4);
        Tags tag5 = new Tags(5, "Fantasia", "Venha fantasiado", evento5);
        Tags tag6 = new Tags(6, "Fantasia", "Venha fantasiado", evento6);
        evento1.getTagsCollection().add(tag1);
        evento2.getTagsCollection().add(tag2);
        evento3.getTagsCollection().add(tag3);
        evento4.getTagsCollection().add(tag4);
        evento5.getTagsCollection().add(tag5);
        evento6.getTagsCollection().add(tag6);


    }
}
