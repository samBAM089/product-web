package de.neuefische.productdemo.service;

import de.neuefische.productdemo.db.OrderDb;
import de.neuefische.productdemo.db.ProductDb;
import de.neuefische.productdemo.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderDb orderDb;
    private final ProductDb productDb;


    public OrderService(OrderDb orderDb, ProductDb productDb) {
        this.orderDb = orderDb;
        this.productDb = productDb;
    }

    public Order add(Order newOrder){
        ArrayList<Order> orderList = this.orderDb.list();
        for (Order order : orderList) {
            if (order.getId().equals(newOrder.getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "order existiert schon");
            }
        }
        return this.orderDb.add(newOrder);
    }


    public List<Order> list() {
        return this.orderDb.list();
    }
}
