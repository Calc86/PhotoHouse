package ru.xsrv.PhotoHouse.server.v1.requests;



import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
//import org.apache.commons.codec.binary.Base64;
import android.util.Base64;
import ru.xsrv.PhotoHouse.server.v1.Acts;
import ru.xsrv.PhotoHouse.server.v1.HTTP;
import ru.xsrv.PhotoHouse.server.v1.Log;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 *
 * Created by Calc on 29.10.2014.
 */
abstract public class Request {
    public static boolean debug = false;

    public static final String version = "1";
    public static final String HASH = "MD5";

    public static final String FIELD_ACT = "act";
    public static final String FIELD_TIME = "time";
    //registration
    public static final String FIELD_FIRST_NAME = "firstname";
    public static final String FIELD_LAST_NAME = "lastname";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_EMAIL = "email";

    //Upload
    public static final String FIELD_IMAGE = "image";
    public static final String FIELD_USER_ID = "user_id";
    public static final String FIELD_ALBUM_ID = "album_id";
    public static final String FIELD_SIG = "sig";

    //add album
    public static final String FIELD_ALBUM = "album";

    //order
    public static final String FIELD_FULL_NAME = "full_name";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_DESCRIPTION  = "description";
    public static final String FIELD_STATUS = "status";
    public static final String SERVER_ADDRESS = "http://p18831-hostde1.fornex.org/serv/";

    //feedback
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_MESSAGE = "message";

    protected Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    protected final Acts act;
    protected long time;

    protected JsonObject root = new JsonObject();

    //обязательные параметры
    private String sig;
    public static final String SALT = "wOwsAlTsoSaLt$o$aFeVERYsecure";

    public Request(Acts act) {
        this.act = act;
        this.time = timestamp();
    }

    private String createHexString(byte[] bytes){
        // Create Hex String
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String h = Integer.toHexString(0xFF & b);
            while (h.length() < 2)
                h = "0" + h;
            hexString.append(h);
        }
        return hexString.toString();
    }

    protected String md5(final String s){
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance(HASH);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            return createHexString(messageDigest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String base64(byte[] bytes){
        return new String(Base64.encode(bytes, Base64.DEFAULT));
        //return new String(Base64.encodeBase64(bytes));
    }

    public static String base64(String str){
        return base64(str.getBytes());
    }

    public static String base64Decode(String string){
        //return new String(Base64.decodeBase64(string));
        return new String(Base64.decode(string, Base64.DEFAULT));
    }

    protected long timestamp(){
        return System.currentTimeMillis() / 1000 + 60*60;
    }

    protected String createToken(Map<String, String> inputParams){
        String hash = "";
        for (String key : inputParams.keySet()){
            String val = inputParams.get(key);
            hash += key + "=" + val;
        }

        String saltHash = md5(SALT);

        return md5(hash + saltHash);
    }

    abstract public void build();

    @Override
    public String toString() {
        this.build();

        return gson.toJson(root);
    }

    private class Task extends AsyncTask<String, Void, String>{
        private IOException exception;
        private boolean work = true;
        private String result;

        @Override
        protected String doInBackground(String... params) {
            try{
                result = _send();
                work = false;
                return result;
            }catch (IOException e){
                work = false;
                exception = e;
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            work = false;
        }
    }

    public String send() throws IOException {
        Task task = new Task();

        task.execute("");

        //wait for task
        while(task.work){
            try {
                Log.debug("wait 1 sec");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.debug(e.getMessage());
                e.printStackTrace();
            }
        }

        if(task.exception != null) throw task.exception;

        return task.result;
    }

    private String _send() throws IOException {
        HTTP http = new HTTP();

        String data;

        //if(debug) System.out.println(this.toString());
        if(debug) Log.debug(this.toString());

        try {
            data = URLEncoder.encode(Request.base64(this.toString()), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        String ret = Request.base64Decode(http.postContent(SERVER_ADDRESS, "data=" + data + "\n"));
        //if(debug) System.out.println(ret);
        if(debug) Log.debug(ret);

        return ret;
    }
}
