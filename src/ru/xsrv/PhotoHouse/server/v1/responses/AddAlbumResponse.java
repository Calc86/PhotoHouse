package ru.xsrv.PhotoHouse.server.v1.responses;

/**
 *
 * Created by calc on 03.11.14.
 */
public class AddAlbumResponse extends Response {
    private String add_album;

    @Override
    protected String getStatus() {
        return add_album;
    }
}
