package ru.xsrv.PhotoHouse.server.v1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by calc on 10.06.14.
 *
 */
public class HTTP {
    //private URL url;
    //private URLConnection connection;

    private URL createURL(String url) throws MalformedURLException {
        return new URL(url);
    }

    private URLConnection createConnection(URL url){
        try {
            return url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }

    public boolean putContent(String url, String file) throws MalformedURLException {
        URL u = createURL(url);
        URLConnection connection = createConnection(u);

        if(connection == null) return false;

        InputStream in;

        try {
            in = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        File f = new File(file);
        try {
            if(f.createNewFile())
                System.out.println("Create file: " + f.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out;
        try {
            out = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        byte[] buffer = new byte[1024];
        int bytes;

        try{
            while((bytes = in.read(buffer)) != -1){
                out.write(buffer, 0, bytes);
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }

        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public String postContent(String urlString, String post) throws IOException {
        URL url = createURL(urlString);
        URLConnection connection = createConnection(url);
        if(connection == null) return "";
        ((HttpURLConnection) connection).setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");

        connection.setRequestProperty("Content-Length", "" +
                Integer.toString(post.getBytes().length));
        connection.setRequestProperty("Content-Language", "en-US");

        connection.setUseCaches (false);
        connection.setDoInput(true);
        connection.setDoOutput(true);


        //Send request
        DataOutputStream wr = new DataOutputStream(
                connection.getOutputStream ());
        wr.writeBytes (post);
        wr.flush ();
        wr.close ();

        String content = "";

        BufferedReader reader;

        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        String line;
        try {
            while( (line = reader.readLine()) != null ){
                content = content + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }

    public String getContent(String urlString) throws MalformedURLException {
        URL url = createURL(urlString);
        URLConnection connection = createConnection(url);

        if(connection == null) return "";

        String content = "";

        BufferedReader reader;

        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        String line;
        try {
            while( (line = reader.readLine()) != null ){
                content = content + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }
}
