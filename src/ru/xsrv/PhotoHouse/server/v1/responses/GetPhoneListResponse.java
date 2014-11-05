package ru.xsrv.PhotoHouse.server.v1.responses;

import ru.xsrv.PhotoHouse.model.types.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by calc on 03.11.14.
 */
public class GetPhoneListResponse extends Response {
    private String get_phone_list;

    private ArrayList<Phone> phones = new ArrayList<Phone>();

    @Override
    protected String getStatus() {
        return get_phone_list;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
