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
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Test
    public void addOrderTest() {
        //given (productDb ist eigentlich nicht notwendig
        ProductDb productDbMock = mock(ProductDb.class);
        OrderDb orderDbMock = mock(OrderDb.class);


        //alles mocken, also immer wenn orderDb in add()aufgerufen wird
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<String> productIdList = new ArrayList<String>(List.of("1", "2"));
        Order order1 = new Order("order1", productIdList);


        when(orderDbMock.list()).thenReturn(orders);

        when(orderDbMock.add(order1)).thenReturn(order1);

        OrderService orderService = new OrderService(orderDbMock, productDbMock);


        //when
        orderService.add(order1);
        orders.add(order1);
        List<Order> actual = orderService.list();

        Order expected = new Order("order1", productIdList);

        //then

        assertThat(actual, contains(expected));
        // verifiziert, dass add() wirklich aufgerufen wird
        verify(orderDbMock).add(order1);

    }

    @Test
    public void addExistingOrderTest() {
        //given
        ProductDb productDbMock = mock(ProductDb.class);
        OrderDb orderDbMock = mock(OrderDb.class);
        OrderService orderService = new OrderService(orderDbMock, productDbMock);

        ArrayList<String> productIdList = new ArrayList<String>(List.of("1", "2"));

        Order order1 = new Order("order1", productIdList);
        ArrayList<Order> orders = new ArrayList<>();

        when(orderDbMock.add(order1)).thenReturn(order1);
        when(orderDbMock.list()).thenReturn(orders);

        orderService.add(order1);
        //hier mnuss manuell die Methode aufgerufen werden, weil unsere orderDbMock aktuell
        //keine Methoden beinhaltet
        orders.add(order1);


        //when
        try {
            orderService.add(order1);
            fail();
        } catch (ResponseStatusException actual) {
            assertEquals(HttpStatus.BAD_REQUEST, actual.getStatus());
        }


    }


}