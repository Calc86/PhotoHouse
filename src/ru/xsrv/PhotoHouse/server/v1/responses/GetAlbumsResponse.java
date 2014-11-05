package ru.xsrv.PhotoHouse.server.v1.responses;


import ru.xsrv.PhotoHouse.model.types.Album;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by calc on 03.11.14.
 */
public class GetAlbumsResponse extends Response {
    private String get_albums;

    private ArrayList<Album> albums = new ArrayList<Album>();

    @Override
    protected String getStatus() {
        return get_albums;
    }

    public List<Album> getGetAlbums() {
        return albums;
    }
}
