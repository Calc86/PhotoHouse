package ru.xsrv.PhotoHouse.ui.gifts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import ru.xsrv.PhotoHouse.R;

/**
 *
 * Created by Calc on 28.10.2014.
 */
public class Gifts extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gifts);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Gifts.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
