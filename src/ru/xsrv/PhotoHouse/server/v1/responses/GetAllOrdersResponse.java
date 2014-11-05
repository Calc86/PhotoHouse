package ru.xsrv.PhotoHouse.server.v1.responses;

import ru.xsrv.PhotoHouse.model.order.OrderJsonAdapter;
import ru.xsrv.PhotoHouse.model.types.Order;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by calc on 03.11.14.
 */
public class GetAllOrdersResponse extends Response {
    private String get_all_orders;

    private List<OrderJsonAdapter> orders = new ArrayList<OrderJsonAdapter>();
    List<Order> realOrders = null;

    //страшная при страшная конструкция....
    public List<Order> getOrders() {
        if(realOrders == null){
            realOrders = new ArrayList<Order>();
            for(OrderJsonAdapter adapter : this.orders){
                realOrders.add(adapter.adapt(new Order()));
            }
        }
        return realOrders;
    }

    @Override
    /*protected String getStatus() {
        return get_all_orders;
    }*/

    //TODO костыль
    protected String getStatus() {
        return OK;
    }
}
