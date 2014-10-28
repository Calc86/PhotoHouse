package ru.xsrv.PhotoHouse.ui.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import ru.xsrv.PhotoHouse.R;

/**
 *
 * Created by Calc on 28.10.2014.
 */
public class ImageAdapter extends BaseAdapter {
    public static final int MAIN_W = 624;
    public static final int MAIN_H = 296;

    public static final int BUTTON_H = 144;

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            if(position == 0) imageView.setLayoutParams(new GridView.LayoutParams(MAIN_W, MAIN_H));
            else imageView.setLayoutParams(new GridView.LayoutParams(MAIN_W, BUTTON_H));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.main_logo, R.drawable.main_1,
            R.drawable.main_2, R.drawable.main_3,
            R.drawable.main_4, R.drawable.main_5,
    };
}
