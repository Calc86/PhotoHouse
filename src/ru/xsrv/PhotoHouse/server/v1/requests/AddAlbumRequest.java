package ru.xsrv.PhotoHouse.server.v1.requests;

import ru.xsrv.PhotoHouse.server.v1.Acts;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class AddAlbumRequest extends Request{
    private String albumName;
    private long userID;
    private String sig;

    public AddAlbumRequest(String albumName, long userID, String sig) {
        super(Acts.ADD_ALBUM);
        this.albumName = albumName;
        this.userID = userID;
        this.sig = sig;
    }

    @Override
    public void build() {
        root.addProperty(FIELD_ACT, act.toString());

        root.addProperty(FIELD_ALBUM, albumName);
        root.addProperty(FIELD_USER_ID, userID);
        root.addProperty(FIELD_SIG, sig);

        root.addProperty(FIELD_TIME, Long.toString(time));
    }

}
