package ru.xsrv.PhotoHouse.server.v1;

/**
 *
 * Created by Calc on 05.11.2014.
 */
public enum ItemType {
    MUG(1), T_SHORT(2), MOUSE_PAD(3), PUZZLE(4), COVER_IPHONE4(5), COVER_IPHONE5(6),
    ALBUM_8X10(7), ALBUM_10X15(8), ALBUM_10X13_5(9), ALBUM_13_18(10), ALBUM_15_21(11), ALBUM_20_30(12);

    private long id;

    public long getId() {
        return id;
    }

    ItemType(long id) {
        this.id = id;
    }
}
