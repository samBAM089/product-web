package de.neuefische.productdemo.db;

import de.neuefische.productdemo.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

class ProductDbTest {


    @Test
    public void addProductTester(){
        //Given
        //
        ProductDb productDb = new ProductDb();


        //When
        productDb.addProduct(new Product("5", "Kerze"));
        List<Product> actual = productDb.listProducts();


        //Then
        assertThat(actual, contains(
                new Product("1", "Stuhl"),
                new Product("2", "Tisch"),
                new Product("3", "Decke"),
                new Product("4", "Topf"),
                new Product("5", "Kerze")));
    }

    @Test
    public void addProductTestUnordered(){
        //Given

        ProductDb productDb = new ProductDb();


        //When
        productDb.addProduct(new Product("5", "Kerze"));
        List<Product> actual = productDb.listProducts();


        //Then
        assertThat(actual, containsInAnyOrder(
                new Product("1", "Stuhl"),
                new Product("2", "Tisch"),
                new Product("4", "Topf"),
                new Product("3", "Decke"),
                new Product("5", "Kerze")));
    }

}