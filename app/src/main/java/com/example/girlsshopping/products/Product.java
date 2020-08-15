package com.example.girlsshopping.products;

import android.net.Uri;

public class Product {


    private int phot;
    private String name;
    private String description;
    private ProductCategory category;
    private String  price;
    private long id;
    private String photoString;
    private Uri uri;

    public int getPhot() {
        return phot;
    }

    public String getPhotoString() {
        return photoString;
    }

    public void setPhotoString(String photoString) {
        this.photoString = photoString;
    }

    public void setPhot(int phot) {
        this.phot = phot;
    }

    public Product(String name, String description, ProductCategory category, String price, String photoString) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.photoString = photoString;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Product(String name, String description, ProductCategory category, String price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;

    }


    public Product(int phot, String name, String description) {
        this.name = name;
        this.phot=phot;
        this.description = description;
        this.category = category;
        this.price = price;

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


}