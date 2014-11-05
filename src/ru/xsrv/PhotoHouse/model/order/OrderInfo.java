package ru.xsrv.PhotoHouse.model.order;

/**
 *
 * Created by calc on 03.11.14.
 */
public class OrderInfo {
    private long id = 0;
    private String full_name;
    private String address;
    private String phone;
    private String description;
    private String date;
    //private int status = OrderStatus.NEW.getCode();
    private long user_id;
    private long studio_id;

    public OrderInfo(String full_name, String address, String phone, String description, long user_id) {
        this.full_name = full_name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.user_id = user_id;
    }
}
