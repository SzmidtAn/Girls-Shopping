package com.example.girlsshopping.ui.favourites;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.R;
import com.example.girlsshopping.products.Product;
import com.example.girlsshopping.products.ProductRecyclerViewAdapter;
import com.example.girlsshopping.products.ProductsDataBase;
import com.example.girlsshopping.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FavouritesFragment extends Fragment {

    private HomeFragment.OnProductClickedListener onProductClickedListener;

    private RecyclerView recyclerView;

    private FavouritesRecyclerViewAdapter productRecyclerViewAdapter;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        List<Product> expenses = ProductsDataBase.getDataBase(view.getContext()).getProductDao().findAll();

        List<Product> favourites=new ArrayList<>();

        for (int i = 0; i <expenses.size() ; i++) {
            if (expenses.get(i).isFavourite()) {
                favourites.add(expenses.get(i));
            }else {
                favourites.remove(expenses.get(i));
            }
        }

        System.out.println(favourites);



        productRecyclerViewAdapter = new FavouritesRecyclerViewAdapter(favourites);
        recyclerView.setAdapter(productRecyclerViewAdapter);






        return view;



    }
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onProductClickedListener = (HomeFragment.OnProductClickedListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnAnimalClickedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onProductClickedListener = null;
    }

    public HomeFragment.OnProductClickedListener getOnProductClickedListener() {
        return onProductClickedListener;
    }

    @Override
    public void onStart() {
        super.onStart();





    }



    public interface OnProductClickedListener {
        void onProductClicked(int id);
    }


    public void refreshAdapterData() {
        List<Product> expenses = ProductsDataBase.getDataBase(getContext()).getProductDao().findAll();
        if (expenses!= null){

            productRecyclerViewAdapter.setExpenses(expenses);
            productRecyclerViewAdapter.notifyDataSetChanged();
        }



    }

}