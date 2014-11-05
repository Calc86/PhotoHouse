package ru.xsrv.PhotoHouse.server.v1.responses;

import ru.xsrv.PhotoHouse.model.order.OrderInfo;
import ru.xsrv.PhotoHouse.model.order.OrderItem;

import java.util.ArrayList;

/**
 *
 * Created by calc on 03.11.14.
 */
public class OrderResponse extends Response {
    private String order;
    private String upload;

    private OrderInfo order_info;
    private ArrayList<OrderItem> order_items = new ArrayList<OrderItem>();

    @Override
    protected String getStatus() {
        return order;
    }
}
