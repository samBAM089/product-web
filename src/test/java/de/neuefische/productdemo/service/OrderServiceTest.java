package de.neuefische.productdemo.service;

import de.neuefische.productdemo.db.OrderDb;
import de.neuefische.productdemo.db.ProductDb;
import de.neuefische.productdemo.model.Order;
import de.neuefische.productdemo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    public void addOrderTest() {
        //given
        ProductDb productDb = new ProductDb();
        OrderDb orderDb = new OrderDb();
        OrderService orderService = new OrderService(orderDb, productDb);

        ArrayList<String> productIdList = new ArrayList<String>(List.of("1", "2"));

        Order order1 = new Order("order1", productIdList);

        //when
        orderService.add(order1);
        List<Order> actual = orderService.list();

        Order expected = new Order("order1", productIdList);

        //then

        assertThat(actual, contains(expected));
    }

    @Test
    public void addExixtingOrderTest(){
        //given
        ProductDb productDb = new ProductDb();
        OrderDb orderDb = new OrderDb();
        OrderService orderService = new OrderService(orderDb, productDb);

        ArrayList<String> productIdList = new ArrayList<String>(List.of("1", "2"));

        Order order1 = new Order("order1", productIdList);
        orderService.add(order1);

        //when
       try {
           orderService.add(order1);
           fail();
       }
       catch (ResponseStatusException actual){
          assertEquals(HttpStatus.BAD_REQUEST, actual.getStatus());
       }


    }




}