package com.acn.jive.weatherApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    public HttpURLConnection createApiConnection(String urlString){
        try{
            // attempt to create connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set request method to get
            conn.setRequestMethod("GET");

            return conn;
        }catch(IOException e){
            e.printStackTrace();
        }

        // could not make connection
        return null;
    }
}
