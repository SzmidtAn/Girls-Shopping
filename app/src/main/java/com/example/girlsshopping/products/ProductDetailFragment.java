package com.example.girlsshopping.products;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.girlsshopping.R;
import com.example.girlsshopping.dialog.DialogMail;
import com.example.girlsshopping.dialog.ShopDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;

import static android.content.Context.MODE_PRIVATE;

public class ProductDetailFragment extends Fragment {

    public static final String PRODUCTS_ID = "extra.product_id";
    private TextView title;
    private TextView price;
    private ImageView imageView;
    private TextView description;
    private Button button;
    private String photoString;
    private Uri uri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        title = (TextView) view.findViewById(R.id.ttitle);
        imageView = (ImageView) view.findViewById(R.id.imageDetailFragment);
        description = (TextView) view.findViewById(R.id.description);
        price=view.findViewById(R.id.priceDetail);
        button=view.findViewById(R.id.buttonShop);







        FloatingActionButton fabMail = view.findViewById(R.id.fabMail);
        fabMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager=getParentFragmentManager();
                DialogMail dialogMail =new DialogMail();
                dialogMail.show(manager, "DialogMail");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager=getParentFragmentManager();
                ShopDialogFragment shopDialogFragment=new ShopDialogFragment();
                shopDialogFragment.show(manager, "ShopDialogFragment");
            }
        });




        if(getArguments() != null) {
            int animalId = getArguments().getInt(PRODUCTS_ID);
            showAnimal(ProductRepository.getProductList().get(animalId));
        }


        for (int i = 0; i <ProductRepository.getProductList().size() ; i++) {
            System.out.println(ProductRepository.getProductList().get(i).getPhotoString().toString());
        }


        return view;
    }




    @SuppressLint("SetTextI18n")
    public void showAnimal(Product product) {

        if (product.getName() != null) {
            price.setText(product.getName() + " zł");
        }else
            price.setText( "99,99 zł");

        if (product.getDescription() != null) {
            price.setText(product.getDescription() + " zł");
        }else
            price.setText( "99,99 zł");

        if (product.getPhotoString() != null){



            Glide.with(getActivity().getApplicationContext())
                .asBitmap()
                .load(product.getPhotoString())
                    .into(imageView);
        }else
            Glide.with(this)
                .asBitmap()
                .load(R.drawable.backpack)
                .into(imageView);



        if (product.getPrice() != null) {
            price.setText(product.getPrice() + " zł");
        }else
            price.setText( "99,99 zł");

        button.setText("Kup teraz");
    }




}