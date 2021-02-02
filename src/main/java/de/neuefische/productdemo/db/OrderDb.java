package de.neuefische.productdemo.db;

import de.neuefische.productdemo.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDb {

    private ArrayList<Order> orderList;

    public OrderDb() {
        orderList = new ArrayList<>();
    }

    public Order add(Order order){
        this.orderList.add(order);
        return order;
    }

    public ArrayList<Order> list(){
        return this.orderList;
    }

}
