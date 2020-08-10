package com.example.girlsshopping.products;

public class Product {

    private int image;
    private String name;
    private String description;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product(int image, String name) {
        this.image = image;
        this.name = name;

    }

    public Product(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    public String getDescription() {
        return description;
    }
}