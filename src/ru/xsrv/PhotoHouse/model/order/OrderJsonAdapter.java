package ru.xsrv.PhotoHouse.model.order;

import ru.xsrv.PhotoHouse.model.types.Order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Calc on 05.11.2014.
 */
public class OrderJsonAdapter {
    private OrderInfo order_info;
    private List<OrderItem> order_items = new ArrayList<OrderItem>();

    public Order adapt(Order order){
        order.setOrderInfo(order_info);
        order.setItems(order_items);

        return order;
    }
}
