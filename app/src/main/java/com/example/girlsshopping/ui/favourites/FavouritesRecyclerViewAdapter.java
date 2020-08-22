package com.example.girlsshopping.ui.favourites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.girlsshopping.MainActivity;
import com.example.girlsshopping.R;
import com.example.girlsshopping.products.Product;
import com.example.girlsshopping.products.ProductDetailActivity;
import com.example.girlsshopping.products.ProductDetailFragment;
import com.example.girlsshopping.products.ProductRecyclerViewAdapter;
import com.example.girlsshopping.products.ProductsDataBase;
import com.example.girlsshopping.ui.home.HomeFragment;

import java.util.List;

public class FavouritesRecyclerViewAdapter extends RecyclerView.Adapter<FavouritesRecyclerViewAdapter.FavouritesRecyclerViewHolder> {

    private List<Product> favourites;
    ImageButton shareCheckBox;
    ImageButton likeCheckBox;
    ImageButton messageCheckBox;

    public FavouritesRecyclerViewAdapter(List<Product> favourites) {
        this.favourites = favourites;
    }

    public void setExpenses(List<Product> favourites) {
        this.favourites = favourites;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.products_list;
    }

    @NonNull
    @Override
    public FavouritesRecyclerViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        final View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.products_list, parent, false);

        shareCheckBox = v.findViewById(R.id.shareButton);
        messageCheckBox = v.findViewById(R.id.messageButton);
        likeCheckBox=v.findViewById(R.id.likeCkeckBox);

        messageCheckBox.setOnClickListener(view -> {
            Context context = view.getContext();
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, "a.szmidt95@gmail.com");
            intent.setType("message/rfc822");
            Intent chooser=Intent.createChooser(intent, "Wyślij e-maila");
            context.startActivity(chooser);

            Toast.makeText(parent.getContext(), "Wyślij wiadomość do sprzedawcy", Toast.LENGTH_SHORT).show();
        });



        return new com.example.girlsshopping.ui.favourites.FavouritesRecyclerViewAdapter.FavouritesRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouritesRecyclerViewHolder holder, int position) {
        final Product product = favourites.get(position);

        if (product !=null){


            if (product.isFavourite()) {
                likeCheckBox.setImageResource(R.drawable.red_heartt_t_foreground);

            } else if (!product.isFavourite()){
                likeCheckBox.setImageResource(R.mipmap.heart_foreground);
            }


            holder.textViewNameProd.setText(product.getName());
            holder.productsPrice.setText(product.getPrice() + " zł");

            Glide.with(holder.viewImage.getContext())
                    .asBitmap()
                    .load(product.getPhotoString())
                    .centerCrop()
                    .into(holder.viewImage);



            likeCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    updateProductLike(product);
                    Toast.makeText(view.getContext(), "Dodano/usunięto z ulubionych", Toast.LENGTH_SHORT).show();


                    ProductsDataBase.getDataBase(view.getContext()).getProductDao().update(product);

                    notifyItemChanged(position);
                }
            });







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
    }

    private void updateProductLike(Product product) {
        if (product.isFavourite()) {
            product.setFavourite(false);
            likeCheckBox.setImageResource(R.mipmap.heart_foreground);

        } else if (!product.isFavourite()){
            product.setFavourite(true);
            likeCheckBox.setImageResource(R.drawable.red_heartt_t_foreground);
        }
    }

    public static class FavouritesRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView viewImage;
        public TextView textViewNameProd;
        public TextView productsPrice;

        public FavouritesRecyclerViewHolder(View itemView) {
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

            ProductDetailFragment productDetailFragment=new ProductDetailFragment();

            int i=getLayoutPosition();
            bundle.putInt(ProductDetailFragment.PRODUCTS_ID, i);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

    }

    @Override
    public int getItemCount() {
        return favourites.size();
    }
}
