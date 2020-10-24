package com.ovalle.exampleproyect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolderDatos> {

    private ArrayList<Producto> productos;
    public AdapterProducto(ArrayList<Producto> lista){
        productos = lista;
    }

    @NonNull
    @Override
    public AdapterProducto.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_product,null, false);
        ViewHolderDatos viewHolderDatos = new ViewHolderDatos(view);
        return viewHolderDatos;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProducto.ViewHolderDatos holder, int position) {
        holder.CargarProducto(productos.get(position));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtProductName, txtProductPrice, txtDescrip;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
            txtDescrip = itemView.findViewById(R.id.txtDescrip);
        }

        public void CargarProducto(Producto prod){
            txtProductName.setText(prod.getNombre());
            txtProductPrice.setText("$"+prod.getPrecio());
            txtDescrip.setText(prod.getDescripcion());

            switch(  prod.getNombre() ){
                case "Hamburgesa":
                    Picasso.get().load(R.drawable.hamburguesa).into(imageView);
                    break;
                case "Papas fritas":
                    Picasso.get().load(R.drawable.french_fries).into(imageView);
                    break;
                case "Bebida":
                    Picasso.get().load(R.drawable.soda).into(imageView);
                    break;
                case "Donut":
                    Picasso.get().load(R.drawable.rosquilla).into(imageView);
                    break;
                case "Café":
                    Picasso.get().load(R.drawable.coffee_cup).into(imageView);
                    break;
                case "Pizza familiar":
                    Picasso.get().load(R.drawable.pizza).into(imageView);
                    break;
                default:
                    Picasso.get().load(R.drawable.fast_food).into(imageView);
                    break;
            }
        }
    }
}
