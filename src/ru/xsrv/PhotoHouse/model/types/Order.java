package ru.xsrv.PhotoHouse.model.types;

import ru.xsrv.PhotoHouse.model.order.OrderImage;
import ru.xsrv.PhotoHouse.model.order.OrderInfo;
import ru.xsrv.PhotoHouse.model.order.OrderItem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by calc on 03.11.14.
 */
public class Order {
    private OrderInfo orderInfo;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public void addItem(OrderItem item){
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    //for adapter
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<OrderImage> getImages(){
        List<OrderImage> images = new ArrayList<OrderImage>();

        for(OrderItem item : items){
            for (OrderImage image : item.getImages()){
                images.add(image);
            }
        }

        return images;
    }

    public boolean isAllImagesUploaded(){
        for (OrderImage image : getImages()){
            if(!image.isUploaded()) return false;
        }
        return true;
    }
}
