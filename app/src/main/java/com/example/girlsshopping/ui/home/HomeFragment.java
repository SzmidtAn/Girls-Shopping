package com.example.girlsshopping.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.R;
import com.example.girlsshopping.products.Product;
import com.example.girlsshopping.products.ProductRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFragment extends Fragment{

    ProductRecyclerViewAdapter adapter;
    CardView cardView;

    // Add RecyclerView member
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {




        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        Product[] possibleAnimals = {
                new Product("Kapelusz", R.drawable.hat),
                new Product("Plecak", R.drawable.backpack),
                new Product("Czapka", R.drawable.cap),
                new Product("Buty", R.drawable.shoes),
                new Product("Okulary przeciwsłoneczne", R.drawable.sunglases),
                new Product("Okulary przeciwsłoneczne", R.drawable.suunglases),
                new Product("Koszulka M", R.drawable.tshirt)};


        final List<Product> animals = new ArrayList<>(100);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Product randomAnimal = possibleAnimals[random.nextInt(possibleAnimals.length)];
            Product animal = new Product(randomAnimal.getName(), randomAnimal.getImage());
            animals.add(animal);
        }

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.rvProducts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        adapter = new ProductRecyclerViewAdapter(animals);
        recyclerView.setAdapter(adapter);




        return view;
    }
}