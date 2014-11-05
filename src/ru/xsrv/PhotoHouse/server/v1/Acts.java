package ru.xsrv.PhotoHouse.server.v1;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public enum Acts {
    REGISTRATION, AUTH,
    UPLOAD, FEEDBACK, ADD_ALBUM, GET_ALBUMS, GET_PHONE_LIST, GET_ADDRESS_LIST, ORDER,
    GET_ALL_ORDERS
    ;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }


}
