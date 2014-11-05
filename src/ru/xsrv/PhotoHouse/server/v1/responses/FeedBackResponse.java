package ru.xsrv.PhotoHouse.server.v1.responses;

/**
 *
 * Created by calc on 03.11.14.
 */
public class FeedBackResponse extends Response {
    private String feedback;

    @Override
    protected String getStatus() {
        return feedback;
    }
}
