package com.productmanagementthymeleaf.model;

public class Product {
    private int id;
    private String name;
    private long price;
    private String detail;
    private String producer;
    private static int count;


    public Product(String name, long price, String detail, String producer) {
        this.id = ++ count;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.producer = producer;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
