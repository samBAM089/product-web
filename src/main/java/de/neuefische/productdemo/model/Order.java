package de.neuefische.productdemo.model;

import java.util.ArrayList;

public class Order {
    private String id;
    private ArrayList<String> productIds;


    //wichtig für das JSON Object
    public Order() {
    }

    public Order(String id, ArrayList<String> productIds) {
        this.id = id;
        this.productIds = productIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<String> productIds) {
        this.productIds = productIds;
    }
}
