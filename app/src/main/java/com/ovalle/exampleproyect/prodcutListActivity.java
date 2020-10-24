package com.ovalle.exampleproyect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class prodcutListActivity extends AppCompatActivity {
    private RecyclerView productRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodcut_list);

        productRecycler = findViewById(R.id.productRecycler);
        productRecycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Producto> listadoProductos = new ArrayList<>();
        listadoProductos.add(new Producto(1,"café",990,"tha tero weno"));
        listadoProductos.add(new Producto(1,"Hamburgesa",1500,"tha tero weno"));
        listadoProductos.add(new Producto(1,"Donut",990,"tha tero weno"));
        listadoProductos.add(new Producto(1,"Bebida",890,"tha tero weno"));
        listadoProductos.add(new Producto(1,"Papas fritas",1000,"tha tero weno"));
        listadoProductos.add(new Producto(1,"Pzza familiar",12000,"tha tero weno"));
        

        AdapterProducto adaptador = new AdapterProducto(listadoProductos);
        productRecycler.setAdapter(adaptador);


    }
}