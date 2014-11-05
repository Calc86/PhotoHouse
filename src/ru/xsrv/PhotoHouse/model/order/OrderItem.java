package ru.xsrv.PhotoHouse.model.order;


import ru.xsrv.PhotoHouse.server.v1.ItemType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class OrderItem {
    private long item_id;
    private long item_num = 1;
    private List<OrderImage> images = new ArrayList<OrderImage>();
    private int image_proc;

    private Map<String, String> props = new HashMap<String, String>();

    //TODO баг сервера, потом убрать аррай лист
    private ArrayList<ItemInfo> item_info; //must be null for property json on server, i just lazy to find another way, but in future....)

    public OrderItem(ItemType type) {
        this.item_id = type.getId();
    }

    protected void addImage(OrderImage image){
        images.add(image);
    }

    public void setCount(int count){
        item_num = count;
    }

    public void setProperties(String name, String value){
        props.put(name, value);
    }

    public List<OrderImage> getImages() {
        return images;
    }
}
