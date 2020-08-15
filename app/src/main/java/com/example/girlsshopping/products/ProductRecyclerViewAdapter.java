package com.example.girlsshopping.products;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.girlsshopping.R;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.RecyclerViewHolder> {

    private List<Product> products;

    public ProductRecyclerViewAdapter(Context context, List<Product> animals) {

        this.products = animals;
    }

    public ProductRecyclerViewAdapter(List<Product> productList) {
this.products=productList;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.products_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_list, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);





        final CheckBox checkBox=v.findViewById(R.id.checkBoxList);

        checkBox.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //is chkIos checked?
        if (((CheckBox) v).isChecked()) {
            Toast.makeText(parent.getContext(), "Jak miło, że podoba Ci się nasz produkt :)", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(parent.getContext(), "No trudno :(", Toast.LENGTH_LONG).show();

        }

    }
});
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        final Product product = products.get(position);

        if (product !=null){

            if (product.getName() != null) {

                holder.textViewNameProd.setText(product.getName());
            }
        if (product.getPrice() != null) {
            holder.productsPrice.setText(product.getPrice() + " zł");
        }


            if (product.getPhotoString() != null) {
                Glide.with(holder.viewImage.getContext())
                        .asBitmap()
                        .load(Uri.parse(product.getPhotoString()))
                        .into(holder.viewImage);
            }


        }
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView viewImage;
        public TextView textViewNameProd;
        public TextView productsPrice;

        public RecyclerViewHolder (View itemView) {
            super(itemView);
            viewImage = (ImageView) itemView.findViewById(R.id.productsImageView);
            textViewNameProd = (TextView) itemView.findViewById(R.id.nameTeview);
            productsPrice=itemView.findViewById(R.id.price);


            itemView.setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNameProd.getText();
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



    @Override
    public int getItemCount() {
        return products.size();
    }
}
