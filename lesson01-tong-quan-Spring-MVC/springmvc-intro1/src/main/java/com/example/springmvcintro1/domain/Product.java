package com.example.springmvcintro1.domain;

public class Product {
    private String name;
    private String description;
    private float price;
    public void setName(String name) {
        this.name=name;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public void setPrice(float price) {
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}
