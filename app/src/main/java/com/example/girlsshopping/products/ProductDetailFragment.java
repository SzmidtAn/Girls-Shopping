package com.example.girlsshopping.products;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.girlsshopping.R;
import com.example.girlsshopping.dialog.DialogMail;
import com.example.girlsshopping.dialog.ShopDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProductDetailFragment extends Fragment {

    public static final String PRODUCTS_ID = "extra.product_id";
    private TextView title;
    private TextView price;
    private ImageView imageView;
    private TextView description;
    private Button button;
    private TextView category;
    private TextView size;
    private TextView brand;
    private TextView condition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        title = (TextView) view.findViewById(R.id.ttitle);
        imageView = (ImageView) view.findViewById(R.id.imageDetailFragment);
        description = (TextView) view.findViewById(R.id.description);
        price=view.findViewById(R.id.priceDetail);
        button=view.findViewById(R.id.buttonShop);
        category=view.findViewById(R.id.category);
        size=view.findViewById(R.id.size);
        brand=view.findViewById(R.id.brand);
        condition=view.findViewById(R.id.condition);
        FloatingActionButton fabMail = view.findViewById(R.id.fabMail);
        CheckBox checkBox=view.findViewById(R.id.likeCkeckBox);


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(view.getContext(), "Jak miło, że podoba Ci się nasz produkt :)", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(view.getContext(), "No trudno :(", Toast.LENGTH_LONG).show();
                }
            }
        });

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
            showAnimal(ProductsDataBase.getDataBase(getContext()).getProductDao().findAll().get(animalId));
        }

        return view;
    }

    @SuppressLint("SetTextI18n")
    public void showAnimal(Product product) {

        title.setText(product.getName());
        price.setText(product.getPrice() + " zł");
        category.setText("Kategoria: " + product.getCategory() );
        size.setText("Rozmiar: " + product.getSize() );
        brand.setText("Marka: " + product.getBrand() );
        condition.setText("Stan: " + product.getCondition());
        description.setText(product.getDescription());

            Glide.with(this)
                .asBitmap()
                .load(product.getPhotoString())
                    .centerInside()
                    .into(imageView);

        button.setText("Kup teraz");
    }

}