package ru.xsrv.PhotoHouse.model.order.items;


import ru.xsrv.PhotoHouse.model.order.OrderImage;
import ru.xsrv.PhotoHouse.model.order.OrderItem;
import ru.xsrv.PhotoHouse.server.v1.ItemType;
import ru.xsrv.PhotoHouse.server.v1.TShortSize;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class TShortItem extends OrderItem {

    public static final String SIZE = "size";

    public TShortItem(TShortSize size, String frontImage, String backImage) {
        super(ItemType.T_SHORT);

        OrderImage oi;

        oi = new OrderImage(frontImage);
        oi.setIndex(1);
        addImage(oi);

        oi = new OrderImage(backImage);
        oi.setIndex(2);
        addImage(oi);

        setSize(size);
    }

    public void setSize(TShortSize size){
        setProperties(SIZE, size.toString());
    }
}
