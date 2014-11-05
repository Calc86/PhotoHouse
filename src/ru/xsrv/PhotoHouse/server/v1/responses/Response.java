package ru.xsrv.PhotoHouse.server.v1.responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by calc on 03.11.14.
 */
abstract public class Response {
    public static final String OK = "OK";
    public static final String FAIL = "FAIL";

    protected final static Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    private String mysql_error;
    private String error;

    public static <T extends Response> T fromJson(String json, Class<T> c){
        return gson.fromJson(json, c);
    }

    protected String statusFieldName;
    private long timestamp;
    Map<String, String> other = new HashMap<String, String>();

    abstract protected String getStatus();

    public boolean isOk(){
        return getStatus().compareTo(OK) == 0;
    }

    public void process(){
        // just do nothing
    }
}
