package com.example.girlsshopping.products;
import com.example.girlsshopping.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ProductRepository {

    private static List<Product> productList;

    public static void addProduct(Product product) {
        productList.add(product);
    }


    static {
        productList = new ArrayList<>();

    }

    public static List<Product> getProductList() {
        return productList;
    }
}