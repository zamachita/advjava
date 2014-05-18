/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author chaiwat
 */
public class JavaRest {
    
    private String server = "http://beta.rest.ensembl.org";
    
    public String getResponse(String ext) {
        String output = null;
        try {
            URL url = new URL(server + ext);
 
            URLConnection connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            connection.setRequestProperty("Content-Type", "application/json");

            InputStream response = connection.getInputStream();
            int responseCode = httpConnection.getResponseCode();

            if(responseCode != 200) {
              throw new RuntimeException("Response code was not 200. Detected response was "+responseCode);
            }

            Reader reader = null;
            try {
              reader = new BufferedReader(new InputStreamReader(response, "UTF-8"));
              StringBuilder builder = new StringBuilder();
              char[] buffer = new char[8192];
              int read;
              while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
              }
              output = builder.toString();
            } 
            finally {
                if (reader != null) try {
                  reader.close(); 
                } catch (IOException logOrIgnore) {
                  logOrIgnore.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
    
    public static void main(String[] args) {
        JavaRest obj = new JavaRest();
        String ext = "/feature/region/human/7:140424943-140624564?feature=gene;feature=transcript;feature=cds;feature=exon";
        String res = obj.getResponse(ext);
        System.out.println(res);
        
        try {
            JSONArray ja = new JSONArray(res);
            System.out.println("Length = " + ja.length());
            JSONObject jo = (JSONObject) ja.get(0);
            System.out.println("ID : " + jo.getString("ID"));
        } catch (Exception e) {
        }
        
    }
    
}
