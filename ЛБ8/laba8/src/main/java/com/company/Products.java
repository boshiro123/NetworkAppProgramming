package com.company;

import java.util.ArrayList;

public class Products {

    private static ArrayList<Products> products = new ArrayList<>();
    private String productTitle;
    private int count;

    public static ArrayList<Products> getProducts() {
        return products;
    }

    public Products(String productTitle, int count) {
        this.productTitle = productTitle;
        this.count = count;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public static void addProducts(Products product){
        Products.products.add(product);
    }

    public static void editProducts(Products product, String newTitle, int newCount){
        for(Products p : products){
            if(product == p) {
                p.setProductTitle(newTitle);
                p.setCount(newCount);
            }
        }
    }
    public static void removeProducts(String title){
        products.removeIf(p -> p.getProductTitle().equals(title));
    }
}
