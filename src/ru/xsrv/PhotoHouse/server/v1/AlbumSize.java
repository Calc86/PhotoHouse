package ru.xsrv.PhotoHouse.server.v1;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public enum AlbumSize {
    _8X10(ItemType.ALBUM_8X10),
    _10X15(ItemType.ALBUM_10X15),
    _10X13_5(ItemType.ALBUM_10X13_5),
    _13X18(ItemType.ALBUM_13_18),
    _15X21(ItemType.ALBUM_15_21),
    _20X30(ItemType.ALBUM_20_30);

    private ItemType type;

    AlbumSize(ItemType type) {
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().substring(1);
    }
}
