package ru.xsrv.PhotoHouse.server.v1.responses;

import ru.xsrv.PhotoHouse.model.types.Address;

import java.util.ArrayList;

/**
 *
 * Created by calc on 03.11.14.
 */
public class GetAddressListResponse extends Response {
    private String get_address_list;

    private ArrayList<Address> addresses = new ArrayList<Address>();

    @Override
    protected String getStatus() {
        return get_address_list;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }
}
