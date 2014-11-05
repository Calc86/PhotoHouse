package ru.xsrv.PhotoHouse.server.v1.requests;



import com.google.gson.JsonElement;
import ru.xsrv.PhotoHouse.model.order.OrderInfo;
import ru.xsrv.PhotoHouse.model.order.OrderItem;
import ru.xsrv.PhotoHouse.server.v1.Acts;

import java.util.List;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class OrderRequest extends Request {
    public static final String OBJECT_ORDER_INFO = "order_info";
    public static final String OBJECT_ORDER_ITEMS = "items";

    /*private String fullName;
    private String address;
    private String phone;
    private String description;
    private OrderStatus status = OrderStatus.NEW;
    private long userID;*/

    private OrderInfo orderInfo;
    private List<OrderItem> items;

    /*public OrderRequest(String fullName, String address, String phone, String description, long userID, List<OrderItem> items) {
        super(Acts.ORDER);
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.userID = userID;
        this.items = items;
    }*/

    public OrderRequest(OrderInfo orderInfo, List<OrderItem> items) {
        super(Acts.ORDER);

        this.orderInfo = orderInfo;
        this.items = items;
    }


    @Override
    public void build() {
        root.addProperty(FIELD_ACT, act.toString());

        /*JsonObject orderInfo = new JsonObject();

        orderInfo.addProperty(FIELD_FULL_NAME, fullName);
        orderInfo.addProperty(FIELD_ADDRESS, address);
        orderInfo.addProperty(FIELD_PHONE, phone);
        orderInfo.addProperty(FIELD_DESCRIPTION, description);
        orderInfo.addProperty(FIELD_STATUS, status.getCode());
        orderInfo.addProperty(FIELD_USER_ID, userID);*/

        JsonElement orderInfo = gson.toJsonTree(this.orderInfo);
        root.add(OBJECT_ORDER_INFO, orderInfo);

        JsonElement items = gson.toJsonTree(this.items);
        root.add(OBJECT_ORDER_ITEMS, items);

        root.addProperty(FIELD_TIME, Long.toString(time));
    }

}
