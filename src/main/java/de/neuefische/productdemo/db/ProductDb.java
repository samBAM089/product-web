package de.neuefische.productdemo.db;

import de.neuefische.productdemo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDb {

    private ArrayList<Product> productlist = new ArrayList<Product>(List.of(
            new Product("1", "Stuhl"),
            new Product("2", "Tisch"),
            new Product("3", "Decke")
    ));


    public List<Product> listProducts(){
        return this.productlist;
    }

    public Product addProduct(Product product) {
        this.productlist.add(product);
        return product;
    }

}
