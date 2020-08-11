package com.example.girlsshopping.products;

public class Product {

    private int image;
    private String name;
    private String description;
    private ProductCategory category;
    private double price;
    private long id;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

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

    public Product(int image, String name, double price, String description, ProductCategory category) {
        this.price=price;
        this.category=category;
        this.name = name;
        this.image = image;
        this.description = description;
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