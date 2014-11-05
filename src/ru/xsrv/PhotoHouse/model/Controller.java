package ru.xsrv.PhotoHouse.model;

import ru.xsrv.PhotoHouse.model.order.OrderImage;
import ru.xsrv.PhotoHouse.model.order.OrderInfo;
import ru.xsrv.PhotoHouse.model.types.Order;
import ru.xsrv.PhotoHouse.model.types.UploadData;
import ru.xsrv.PhotoHouse.server.v1.Log;
import ru.xsrv.PhotoHouse.server.v1.requests.AuthRequest;
import ru.xsrv.PhotoHouse.server.v1.requests.GetAllOrdersRequest;
import ru.xsrv.PhotoHouse.server.v1.requests.OrderRequest;
import ru.xsrv.PhotoHouse.server.v1.requests.UploadRequest;
import ru.xsrv.PhotoHouse.server.v1.responses.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Calc on 05.11.2014.
 */
public class Controller {
    private User user = null;
    private Order currentOrder = new Order();
    private List<Order> orders = new ArrayList<Order>();    //прошлые заказы

    private static Controller instance = new Controller();

    private Controller() {
    }

    public Order getOrder() {
        return currentOrder;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public static Controller getInstance() {
        return instance;
    }

    public boolean isAuthorized(){
        return user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user){
        if(this.user == null) this.user = user;
        else this.user.copyFrom(user);  //??? по идее излишне в логике.
    }

    public boolean authorize(String email, String password){
        AuthRequest request = new AuthRequest(email, password);
        try {
            String ret = request.send();
            AuthResponse response = Response.fromJson(ret, AuthResponse.class);
            if(response.getUser() != null)
                Controller.getInstance().setUser(response.getUser());
            else return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    protected boolean uploadImage(OrderImage image){
        if(image.isUploaded()) return true;

        try {
            UploadRequest uploadRequest = new UploadRequest(image.getImage(), Controller.getInstance().getUser().getId(), 1l, "");
            String ret = uploadRequest.send();
            UploadResponse uploadResponse = Response.fromJson(ret, UploadResponse.class);
            UploadData uploadData = uploadResponse.getUploadData();
            image.setImage(uploadData.getImagePath());
            image.setUploaded(true);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean uploadImages(){
        for (OrderImage image : currentOrder.getImages()){
            uploadImage(image);
        }
        return true;
    }

    public boolean sendOrder(OrderInfo orderInfo){
        //все ли изображения загружены?
        if(!currentOrder.isAllImagesUploaded()){
            Log.debug("не все изображения загружены, попробуйте еще раз");
            return false;
        }

        currentOrder.setOrderInfo(orderInfo);
        try {
            OrderRequest orderRequest = new OrderRequest(currentOrder.getOrderInfo(), currentOrder.getItems());
            String ret = orderRequest.send();
            OrderResponse orderResponse = Response.fromJson(ret, OrderResponse.class);
            if(!orderResponse.isOk()) return false;
            //заказ отправлен, очищаем память
            currentOrder = new Order();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean getAllOrders(){
        try {
            GetAllOrdersRequest request = new GetAllOrdersRequest(user.getId(), "");
            String ret = request.send();
            GetAllOrdersResponse response = Response.fromJson(ret, GetAllOrdersResponse.class);
            if(!response.isOk()) return false;
            orders = response.getOrders();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
