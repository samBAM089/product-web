package de.neuefische.productdemo.service;

import de.neuefische.productdemo.db.ProductDb;
import de.neuefische.productdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductDb productDb;

    @Autowired
    public ProductService(ProductDb productDb) {
        this.productDb = productDb;
    }

    public List<Product> listProducts() {
        return productDb.listProducts();
    }


    public Product addProduct(Product product){
        return this.productDb.addProduct(product);
    }

}
