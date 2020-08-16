package com.example.girlsshopping.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlsshopping.R;
import com.example.girlsshopping.products.Product;
import com.example.girlsshopping.products.ProductRecyclerViewAdapter;
import com.example.girlsshopping.products.ProductRepository;

import java.util.List;

public class HomeFragment extends Fragment{

    private HomeFragment.OnProductClickedListener onProductClickedListener;

    private RecyclerView recyclerView;

    private ProductRecyclerViewAdapter productRecyclerViewAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        List<Product> expenses = ProductRepository.getProductList();

        productRecyclerViewAdapter = new ProductRecyclerViewAdapter(getActivity(), expenses);
        recyclerView.setAdapter(productRecyclerViewAdapter);






        return view;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onProductClickedListener = (OnProductClickedListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnAnimalClickedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onProductClickedListener = null;
    }

    public OnProductClickedListener getOnProductClickedListener() {
        return onProductClickedListener;
    }

    @Override
    public void onStart() {
        super.onStart();

refreshAdapterData();




    }



    public interface OnProductClickedListener {
        void onProductClicked(int id);
    }


    private void refreshAdapterData() {
        List<Product> expenses = ProductRepository.getProductList();
        if (expenses!= null){

        productRecyclerViewAdapter.setExpenses(expenses);
        productRecyclerViewAdapter.notifyDataSetChanged();
        }



    }

}