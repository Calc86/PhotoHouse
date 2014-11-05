package ru.xsrv.PhotoHouse.server.v1.requests;

import ru.xsrv.PhotoHouse.server.v1.Acts;

/**
 * тестовый класс для произвольного json
 * Created by Calc on 05.11.2014.
 */
public class JsonRequest extends Request {
    private String json = "";

    public JsonRequest() {
        super(Acts.ORDER);
    }

    @Override
    public void build() {
        json = "{\"act\":\"order\", \"order_info\": {\"user_id\": \"12random number\"}, \"time\":\"" + (timestamp()) + "\"}\n";
    }

    @Override
    public String toString() {
        build();
        return json;
    }
}
