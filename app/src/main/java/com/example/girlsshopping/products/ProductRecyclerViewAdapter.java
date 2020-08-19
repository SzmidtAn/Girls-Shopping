package com.example.girlsshopping.products;

import android.content.Context;
import android.content.Intent;
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
import com.example.girlsshopping.MainActivity;
import com.example.girlsshopping.R;
import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.RecyclerViewHolder> {

    private List<Product> products;
    CheckBox shareCheckBox;

    public ProductRecyclerViewAdapter(List<Product> animals) {
        this.products = animals;
    }

    public void setExpenses(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.products_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        final View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_list, parent, false);

        shareCheckBox = v.findViewById(R.id.shareButton);
        CheckBox messageCheckBox = v.findViewById(R.id.messageButton);
        CheckBox checkBox=v.findViewById(R.id.likeCkeckBox);

        messageCheckBox.setOnClickListener(view -> {
            Context context = view.getContext();
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, "a.szmidt95@gmail.com");
            intent.setType("message/rfc822");
            Intent chooser=Intent.createChooser(intent, "Wyślij e-maila");
            context.startActivity(chooser);

            Toast.makeText(parent.getContext(), "Wyślij wiadomość do sprzedawcy", Toast.LENGTH_SHORT).show();
        });


        checkBox.setOnClickListener(v1 -> {
            //is chkIos checked?
            if (((CheckBox) v1).isChecked()) {
                Toast.makeText(parent.getContext(), "Jak miło, że podoba Ci się nasz produkt :)", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(parent.getContext(), "No trudno :(", Toast.LENGTH_SHORT).show();
            }
        });
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        final Product product = products.get(position);

        if (product !=null){

            holder.textViewNameProd.setText(product.getName());
            holder.productsPrice.setText(product.getPrice() + " zł");

            Glide.with(holder.viewImage.getContext())
                        .asBitmap()
                        .load(product.getPhotoString())
                        .centerCrop()
                        .into(holder.viewImage);

        }

        shareCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        ProductsDataBase.getDataBase(view.getContext()).getProductDao().delete(product);
                Toast.makeText(view.getContext(), "Produkt został pomyślnie usunięty", Toast.LENGTH_SHORT).show();

                Context context = view.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });

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

        @NonNull
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
