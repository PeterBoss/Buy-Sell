/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Peter
 */
public class Ebay {

    public String sendGet() throws MalformedURLException, IOException {
        String url = "http://svcs.ebay.com/services/search/FindingService/"
                + "v1?OPERATION-NAME=findItemsByKeywords"
                + "&SERVICE-VERSION=1.0.0"
                + "&SECURITY-APPNAME=PeterTho-test1-PRD-f45f6444c-eaec4193"
                + "&RESPONSE-DATA-FORMAT=XML"
                + "&REST-PAYLOAD"
                + "&keywords=xbox";

        URL obj = new URL(url);
        
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        con.setRequestMethod("GET");
        
        con.setRequestProperty("User-Agent", "");
        
        int responseCode = con.getResponseCode();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        
        while ((inputLine = in.readLine())!= null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    
}
