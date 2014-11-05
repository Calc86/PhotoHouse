package ru.xsrv.PhotoHouse.server.v1.requests;


import org.apache.commons.io.FileUtils;
import ru.xsrv.PhotoHouse.server.v1.Acts;

import java.io.File;
import java.io.IOException;
/*import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;*/

/**
 *
 * Created by Calc on 29.10.2014.
 */
public class UploadRequest extends Request{

    private byte[] image;
    private long userID;
    private long albumID;
    private String sig;

    public UploadRequest(byte[] image, long userID, long albumID, String sig) {
        super(Acts.UPLOAD);
        this.image = image;
        this.userID = userID;
        this.albumID = albumID;
        this.sig = sig;
    }

    public UploadRequest(String imagePath, long userID, long albumID, String sig) throws IOException {
        super(Acts.UPLOAD);
        File file = new File(imagePath);
        if(!file.exists()) throw new IOException("file " + imagePath + " not found");
        this.image = FileUtils.readFileToByteArray(file);

        /*Path path = Paths.get(imagePath);

        this.image = Files.readAllBytes(path);*/
        this.userID = userID;
        this.albumID = albumID;
        this.sig = sig;
    }

    @Override
    public void build() {
        root.addProperty(FIELD_ACT, act.toString());

        root.addProperty(FIELD_IMAGE, base64(image));
        root.addProperty(FIELD_USER_ID, userID);
        root.addProperty(FIELD_ALBUM_ID, albumID);
        root.addProperty(FIELD_SIG, sig);

        root.addProperty(FIELD_TIME, Long.toString(time));
    }

}
