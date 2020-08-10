package com.example.girlsshopping.products;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.R;
import com.example.girlsshopping.ui.home.RecyclerViewHolder;

import java.util.List;
import java.util.Random;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Product> products;

    public ProductRecyclerViewAdapter(List<Product> animals) {
        this.products = animals;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.products_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.products_list, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        viewHolder.textViewNameProd =  v.findViewById(R.id.nameTeview);
        viewHolder.viewImage = v.findViewById(R.id.productsImageView);

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
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.textViewNameProd.setText(product.getName());

        holder.viewImage.setImageResource(product.getImage());
        Random random=new Random();
        int productId=random.nextInt();
        product.setId(productId);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
