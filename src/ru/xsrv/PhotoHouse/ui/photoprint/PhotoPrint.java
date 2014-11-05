package ru.xsrv.PhotoHouse.ui.photoprint;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import ru.xsrv.PhotoHouse.R;
import ru.xsrv.PhotoHouse.server.v1.Log;
import ru.xsrv.PhotoHouse.server.v1.Workflow;
import ru.xsrv.PhotoHouse.server.v1.requests.Request;

/**
 *
 * Created by Calc on 28.10.2014.
 */
public class PhotoPrint extends Activity {
    private int selected = -1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_print);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(PhotoPrint.this, "" + position, Toast.LENGTH_SHORT).show();

                selected = position;

                Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }
        });

    }

    protected String convertMediaUriToPath(Uri uri) {
        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, proj,  null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String path = cursor.getString(column_index);
        cursor.close();
        return path;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode)
        {
            case 1:
            {
                if (resultCode == RESULT_OK)
                {
                    Uri imageUri = data.getData();

                    //Intent intent = new Intent(MainActivity.this, MugActivity.class);
                    //intent.putExtra("image_uri", imageUri.toString());
                    //startActivity(intent);

                    //Toast.makeText(PhotoPrint.this, imageUri.toString() + " " + selected, Toast.LENGTH_LONG).show();
                    String file = "";
                    if(imageUri.getScheme().equals("file"))
                        file = imageUri.toString();
                    else if(imageUri.getScheme().equals("content"))
                        file = convertMediaUriToPath(imageUri);
                    else
                    {
                        Log.debug("Да хрен знает что делать с " + imageUri.toString());
                    }
                    Workflow w = new Workflow(file);
                    w.work();


                }
                break;
            }
        }
    }
}