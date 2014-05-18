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
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author chaiwat
 */
public class ESearchResult {
    
    private int retStart = 0;
    private int retMax   = 10;
    private String term  = "";
    
    private int count;
    private List<String> idList = new ArrayList<String>();
    private String queryTranslation;
    
    private String server= "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/";
    
    private JSONObject jo = null;
    
    public static void main(String[] args) {
        ESearchResult obj = new ESearchResult();
        obj.setTerm("mirna on promoter");
        obj.invoke();
        System.out.println(obj.getIdList());
        System.out.println(obj.getQueryTranslation());
    }
    
    public void invoke() {
        String url = server + "esearch.fcgi?db=pubmed&term=" + term + "&retmode=json&retmax=" + retMax + "&retstart=" + retStart;
        try {
            URL u = new URL(url);
            URLConnection con = u.openConnection();
            InputStream in = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            
            jo = new JSONObject(sb.toString()).getJSONObject("esearchresult");
            count = jo.getInt("count");
            queryTranslation = jo.getString("querytranslation");
            idList = new ArrayList<String>();
            JSONArray ja = jo.getJSONArray("idlist");
            for (int i = 0; i < ja.length(); i++) {
                getIdList().add(ja.get(i).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @param retStart the retStart to set
     */
    public void setRetStart(int retStart) {
        this.retStart = retStart;
    }

    /**
     * @param retMax the retMax to set
     */
    public void setRetMax(int retMax) {
        this.retMax = retMax;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(String term) {
        try {
            this.term = URLEncoder.encode(term, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @return the idList
     */
    public List<String> getIdList() {
        return idList;
    }

    /**
     * @return the queryTranslation
     */
    public String getQueryTranslation() {
        return queryTranslation;
    }
    
}
