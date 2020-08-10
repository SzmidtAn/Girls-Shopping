package com.example.girlsshopping.products;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.girlsshopping.R;
import com.example.girlsshopping.dialog.ShopDialogFragment;

public class ProductDetailFragment extends Fragment {

    public static final String PRODUCTS_ID = "extra.product_id";
    private TextView title;
    private ImageView imageView;
    private TextView description;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        title = (TextView) view.findViewById(R.id.ttitle);
        imageView = (ImageView) view.findViewById(R.id.image);
        description = (TextView) view.findViewById(R.id.description);
        button=view.findViewById(R.id.button);

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
        return view;
    }

    @SuppressLint("SetTextI18n")
    public void showAnimal(Product product) {
        title.setText(product.getName());
        description.setText(product.getDescription());
        imageView.setImageResource(product.getImage());
        button.setText("Kup teraz");
    }




}