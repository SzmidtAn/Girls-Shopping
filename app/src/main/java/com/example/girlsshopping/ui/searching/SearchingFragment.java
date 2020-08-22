package com.example.girlsshopping.ui.searching;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.R;
import com.example.girlsshopping.products.Product;
import com.example.girlsshopping.products.ProductRecyclerViewAdapter;
import com.example.girlsshopping.products.ProductsDataBase;
import com.example.girlsshopping.ui.favourites.FavouritesRecyclerViewAdapter;
import com.example.girlsshopping.ui.gallery.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchingFragment extends Fragment {


    private RecyclerView recyclerView;
    private Adapter productRecyclerViewAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragments_searching, container, false);
        SearchView simpleSearchView = (SearchView) view.findViewById(R.id.simpleSearchView); // inititate a search view
        CharSequence queryHint = simpleSearchView.getQueryHint(); // get the hint text that will be displayed in the query text field





        return view;
    }
}