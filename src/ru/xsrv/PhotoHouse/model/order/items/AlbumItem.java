package ru.xsrv.PhotoHouse.model.order.items;

import ru.xsrv.PhotoHouse.model.exceptions.TooSmallImagesException;
import ru.xsrv.PhotoHouse.model.order.OrderImage;
import ru.xsrv.PhotoHouse.model.order.OrderItem;
import ru.xsrv.PhotoHouse.server.v1.AlbumSize;

import java.util.List;

/**
 *
 * Created by Calc on 05.11.2014.
 */
public class AlbumItem extends OrderItem {
    public static int MIN_IMAGES = 20;

    public AlbumItem(AlbumSize size, List<String> images) throws TooSmallImagesException {
        super(size.getType());

        if(images.size() < MIN_IMAGES)
            throw new TooSmallImagesException(images.size(), 20);

        for(String image : images){
            addImage(new OrderImage(image));
        }
    }
}
