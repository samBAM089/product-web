package de.neuefische.productdemo.controller;


import de.neuefische.productdemo.db.ProductDb;
import de.neuefische.productdemo.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    public final ProductDb productList = new ProductDb(new ArrayList<Product>(List.of(
            new Product("1", "Stuhl"),
            new Product("2", "Tisch"),
            new Product("3", "Decke")
    )));


    @GetMapping("list")
    public ArrayList<Product> listProducts (){
        return productList.listProducts();
    }

    @PutMapping
    public Product addProduct(@RequestBody Product product){
        return productList.addProduct(product);
    }
}
