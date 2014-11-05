package ru.xsrv.PhotoHouse.server.v1;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public enum FeedBackType {
    ERROR(1), FEATURE(2), OTHER(3);

    private int code;

    FeedBackType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
