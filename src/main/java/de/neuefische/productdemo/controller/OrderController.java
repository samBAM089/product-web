package de.neuefische.productdemo.controller;


import de.neuefische.productdemo.db.OrderDb;
import de.neuefische.productdemo.db.ProductDb;
import de.neuefische.productdemo.model.Order;
import de.neuefische.productdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    public OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PutMapping("add")
    public Order addOrder(@RequestBody Order order) {
        return this.orderService.add(order);
    }

    @GetMapping
    public List<Order> getOrderList(){
        return this.orderService.list();
    }

}
