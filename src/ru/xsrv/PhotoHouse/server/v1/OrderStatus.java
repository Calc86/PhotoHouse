package ru.xsrv.PhotoHouse.server.v1;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public enum OrderStatus {
    NEW(1), PREPARED(2), FORMED(3), DELIVERY(4), DELIVERED(5);

    private int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
