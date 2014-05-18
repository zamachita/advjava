/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package example.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author chaiwat
 */
public class NetworkClientExample {
    
    private String server = "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/";
    
    public String getContent(String ext) {
        String output = "";
        try {
            URL u = new URL(ext);
            URLConnection con = u.openConnection();
            InputStream in = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            output = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
    
    public void test() {
        String term = "micro rna";
        try {
            term = URLEncoder.encode(term, "UTF8");
        } catch (Exception e) {
        }
        String ext = "esearch.fcgi?db=pubmed&term=" + term + "&retmode=json";
        System.out.println("URL : " + server + ext);
        String cont = getContent(server + ext);
        
        try {
            JSONObject jo = new JSONObject(cont);
            JSONObject es = jo.getJSONObject("esearchresult");
            JSONArray idList = es.getJSONArray("idlist");
            System.out.println(idList.get(0)); // 24833871
            System.out.println("Count = " + es.getInt("count"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Content : " + cont);
    }
    
    public static void main(String[] args) {
        NetworkClientExample obj = new NetworkClientExample();
        obj.test();
    }
    
}
