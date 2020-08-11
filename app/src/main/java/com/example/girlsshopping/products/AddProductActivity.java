package com.example.girlsshopping.products;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.girlsshopping.R;
import com.example.girlsshopping.products.ProductCategory;

public class AddProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);

        Spinner categorySpinner = findViewById(R.id.expense_category);

        ProductCategory[] categories = ProductCategory.values();
        ArrayAdapter<ProductCategory> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, categories);
        categorySpinner.setAdapter(adapter);

        Button newExpenseButton = findViewById(R.id.add_expense);

        newExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewExpense();
            }
        });

    }

    private void addNewExpense() {
        EditText nameEditText = findViewById(R.id.expense_name);
        EditText descriptionEditText = findViewById(R.id.product_description);
        EditText priceEditText = findViewById(R.id.expense_price);
        Spinner categorySpinner = findViewById(R.id.expense_category);

        String title = nameEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        double price = Double.parseDouble(priceEditText.getText().toString());
        ProductCategory category = (ProductCategory) categorySpinner.getSelectedItem();

        Product product = new Product(R.drawable.backpack, title, price, description, category);
        ProductRepository.addProduct(product);

        Toast.makeText(getApplicationContext(), "Artykuł został dodany poprawnie", Toast.LENGTH_SHORT).show();

        finish();
    }
}