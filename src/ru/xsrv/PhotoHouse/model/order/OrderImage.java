package ru.xsrv.PhotoHouse.model.order;

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class OrderImage {
    private String image;   //url to image on server if from json, or on local if from local
    private int index = 1;
    private boolean uploaded = true;

    public OrderImage(String image) {
        //todo проверка на существование картинки и выброс исключения, если ее нет
        this.image = image;
        this.uploaded = false;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public boolean isUploaded() {
        return uploaded;
    }
}
