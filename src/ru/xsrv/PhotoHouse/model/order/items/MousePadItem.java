package ru.xsrv.PhotoHouse.model.order.items;

import ru.xsrv.PhotoHouse.model.order.OrderImage;
import ru.xsrv.PhotoHouse.model.order.OrderItem;
import ru.xsrv.PhotoHouse.server.v1.ItemType;

/**
 *
 * Created by Calc on 05.11.2014.
 */
public class MousePadItem extends OrderItem {
    public MousePadItem(String image) {
        super(ItemType.MOUSE_PAD);

        addImage(new OrderImage(image));
    }
}
