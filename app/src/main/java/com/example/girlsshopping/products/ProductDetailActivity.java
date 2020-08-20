package com.example.girlsshopping.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.girlsshopping.MainActivity;
import com.example.girlsshopping.R;
import com.example.girlsshopping.ui.favourites.FavouritesFragment;
import com.example.girlsshopping.ui.message.MessageFragment;
import com.example.girlsshopping.ui.searching.SearchingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);



        ProductDetailFragment details = new ProductDetailFragment();
       details.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();




    }


}
