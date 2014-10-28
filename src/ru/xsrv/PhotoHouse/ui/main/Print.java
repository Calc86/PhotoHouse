package ru.xsrv.PhotoHouse.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import ru.xsrv.PhotoHouse.R;
import ru.xsrv.PhotoHouse.ui.gifts.Gifts;
import ru.xsrv.PhotoHouse.ui.photoprint.*;

public class Print extends Activity {
    public static final int PHOTO_PRINT = 1;
    public static final int PHOTO_ALBUM = 2;
    public static final int GIFTS = 3;
    public static final int COVERS = 4;
    public static final int ADDITIONAL = 5;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Print.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch (position){
                    case PHOTO_PRINT:
                        buttonPhotoPrint_Click();
                        break;
                    case PHOTO_ALBUM:
                        buttonPhotoAlbum_Click();
                        break;
                    case GIFTS:
                        buttonGifts_Click();
                        break;
                    case COVERS:
                        buttonCovers_Click();
                        break;
                    case ADDITIONAL:
                        buttonAdditional_Click();
                        break;
                }
            }
        });
    }

    public void buttonPhotoPrint_Click() {
        //chane view to photo print
        Intent intent = new Intent(Print.this, PhotoPrint.class);
        startActivity(intent);
    }

    public void buttonPhotoAlbum_Click() {
        //фотоальбомы
    }

    public void buttonGifts_Click() {
        //подарки и сувениры
        Intent intent = new Intent(Print.this, Gifts.class);
        startActivity(intent);
    }

    public void buttonCovers_Click() {
        //чехлы и обложки
    }

    public void buttonAdditional_Click() {
        //спец предложения
    }
}
