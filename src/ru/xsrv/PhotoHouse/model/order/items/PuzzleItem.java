package ru.xsrv.PhotoHouse.model.order.items;

import ru.xsrv.PhotoHouse.model.order.OrderImage;
import ru.xsrv.PhotoHouse.model.order.OrderItem;
import ru.xsrv.PhotoHouse.server.v1.ItemType;

/**
 *
 * Created by Calc on 05.11.2014.
 */
public class PuzzleItem extends OrderItem {
    public PuzzleItem(String image) {
        super(ItemType.PUZZLE);

        addImage(new OrderImage(image));
    }
}
