package com.example.girlsshopping.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.products.ProductDetailActivity;
import com.example.girlsshopping.products.ProductDetailFragment;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView viewImage;
    public TextView textViewNameProd;

        public RecyclerViewHolder (View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, ProductDetailActivity.class);
            Bundle bundle = new Bundle();

            int i=getLayoutPosition();
            bundle.putInt(ProductDetailFragment.PRODUCTS_ID, i);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }


}