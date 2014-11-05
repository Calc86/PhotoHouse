package ru.xsrv.PhotoHouse.server.v1;

import ru.xsrv.PhotoHouse.model.Controller;
import ru.xsrv.PhotoHouse.model.order.OrderInfo;
import ru.xsrv.PhotoHouse.model.order.items.CoverIPhone4Item;
import ru.xsrv.PhotoHouse.model.order.items.MugItem;
import ru.xsrv.PhotoHouse.model.order.items.TShortItem;
import ru.xsrv.PhotoHouse.server.v1.requests.Request;

/**
 *
 * Created by Calc on 05.11.2014.
 */
public class Workflow {
    public String TEST_JPG = "test.jpg";
    public static final String USER = "calc@calc.calc";
    public static final String PASSWORD = "73851";

    /*
    1) тыкаем по кнопкам
    2) смотрим профиль
    3) если нет авторизирован - авторизируемся
    4) если нет пользователя - регистрируемся
    5) Выбор типа объекта для печати
    6) Помещение в корзину
    7) Попытка сделать заказ
    8) отправка заказа
     */

    public Workflow(String TEST_JPG) {
        this.TEST_JPG = TEST_JPG;
    }

    private void tShort(){
        TShortItem item = new TShortItem(TShortSize.L, TEST_JPG, TEST_JPG);
        Controller.getInstance().getOrder().addItem(item);
    }

    private void mug(){
        MugItem item = new MugItem(TEST_JPG);
        Controller.getInstance().getOrder().addItem(item);
    }

    private void cover(){
        CoverIPhone4Item item = new CoverIPhone4Item(TEST_JPG);
        Controller.getInstance().getOrder().addItem(item);
    }

    private void photo(){
        //not in database
    }

    private void auth(){
        if(!Controller.getInstance().isAuthorized()){
            //authorize
            if(!Controller.getInstance().authorize(USER, PASSWORD)){
                Log.debug("авторизация не прошла");
            }
            else{
                Log.debug("Вошли как: " + Controller.getInstance().getUser().getEmail());
            }
        }
        else{
            Log.debug("Уже авторизированы");
        }
    }

    private void register(){

    }

    private void uploadImages(){
        Controller.getInstance().uploadImages();
    }

    private void sendOrder(){
        Controller.getInstance().sendOrder(
                new OrderInfo(
                        Controller.getInstance().getUser().getFirstname() + " " + Controller.getInstance().getUser().getLastname(),
                        "my address",
                        "phone",
                        "description",
                        Controller.getInstance().getUser().getId()
                )
        );
    }

    private void viewProfile(){
        Log.debug(Controller.getInstance().getUser().getFirstname() + ", " + Controller.getInstance().getUser().getLastname());
    }

    private void viewOrders(){
        Controller.getInstance().getAllOrders();
        Log.debug("Количество заказов: " + Controller.getInstance().getOrders().size());
    }

    public void work(){
        Request.debug = true;
        Log.debug("t-short");
        tShort();
        Log.debug("mug");
        mug();
        Log.debug("cover");
        cover();

        Log.debug("auth");
        auth();

        Log.debug("upload images");
        uploadImages();
        Log.debug("send order");
        sendOrder();

        Log.debug("view profile");
        viewProfile();
        Log.debug("view order");
        viewOrders();

    }

    /*public static void main(String[] args) {
        Request.debug = true;

        Workflow w = new Workflow();
        w.work();
    }*/
}
