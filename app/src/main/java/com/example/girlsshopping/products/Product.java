package com.example.girlsshopping.products;

public class Product {
    String name;
    Integer image;

    public Product(String name, Integer image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Integer getImage() {
        return image;
    }
}
