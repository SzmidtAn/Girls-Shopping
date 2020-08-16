package com.example.girlsshopping.products;

import android.net.Uri;

public class Product {

    private String name;
    private String description;
    private ProductCategory category;
    private String  price;
    private long id;
    private String photoString;




    public Product(String name, String description, ProductCategory category, String price, String photoString) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.photoString = photoString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhotoString() {
        return photoString;
    }

    public void setPhotoString(String photoString) {
        this.photoString = photoString;
    }
}