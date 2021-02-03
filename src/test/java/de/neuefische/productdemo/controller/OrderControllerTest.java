package de.neuefische.productdemo.controller;

import de.neuefische.productdemo.db.OrderDb;

import de.neuefische.productdemo.model.Order;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.emptyArray;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderDb orderDb;

    @Test
    public void getOrderListTest() {
        //Given
        String url = "http://localhost:" + port + "/orders";

        //When
        ResponseEntity<Order[]> response = restTemplate.getForEntity(url, Order[].class);

        //Then
        assertThat(response.getBody(), emptyArray());
    }

    @Test
    public  void addOrderPostTest() {
        //Given
        String url = "http://localhost:" + port + "/orders/add";
        Order orderToSend = new Order("firstOrder",
                new ArrayList<>(List.of("Decke", "Dach", "Boden", "Fenster")));

        Order expected = new Order("firstOrder",
                new ArrayList<>(List.of("Decke", "Dach", "Boden", "Fenster")));

        //When
        ResponseEntity<Order> response = restTemplate.postForEntity(url,orderToSend,Order.class);

        //Then
        assertThat(response.getStatusCode(), Matchers.is(HttpStatus.OK));
        assertThat(response.getBody(), Matchers.is(expected));
    }

}