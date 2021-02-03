package de.neuefische.productdemo.controller;


import de.neuefische.productdemo.db.ProductDb;
import de.neuefische.productdemo.model.Product;
import de.neuefische.productdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }


    @GetMapping("list")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @PutMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }


}
