package com.example.girlsshopping.products;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.MainActivity;
import com.example.girlsshopping.R;
import com.example.girlsshopping.ui.home.RecyclerViewHolder;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Product> products;
    CardView cardView;



    public ProductRecyclerViewAdapter(List<Product> animals) {
        this.products = animals;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.products_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        viewHolder.textViewNameProd =  v.findViewById(R.id.nameTeview);

        viewHolder.cardView=v.findViewById(R.id.productCardView);
        viewHolder.viewImage = v.findViewById(R.id.productsImageView);




        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.textViewNameProd.setText(product.name);
        holder.viewImage.setImageResource(product.image);

       holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Wybrałeś " + product.name + "! \nDobra decyzja :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}