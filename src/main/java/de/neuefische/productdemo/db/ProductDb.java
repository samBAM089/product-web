package de.neuefische.productdemo.db;

import de.neuefische.productdemo.model.Product;

import java.util.ArrayList;

public class ProductDb {

    private ArrayList<Product> productlist;

    public ProductDb(ArrayList<Product> productlist) {
        this.productlist = productlist;
    }

    public ArrayList<Product> listProducts(){
        return this.productlist;
    }

    public Product addProduct(Product product) {
        this.productlist.add(product);
        return product;
    }
}
