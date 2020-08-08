package com.example.girlsshopping.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView viewImage;
    public TextView textViewNameProd;
    public CardView cardView;

    public RecyclerViewHolder(@NonNull final View itemView) {
        super(itemView);


    }

}