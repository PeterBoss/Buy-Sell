
package rest;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("dba")
public class dba {
    @Context
  private UriInfo context;
    
    public dba(){
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{search}")
    public String getDba(@PathParam("search") String search) throws ProtocolException, IOException{
        URL url = new URL("http://www.dba.dk/soeg/?soeg=");
        Gson gson = new Gson();
        String url2 = "https://extraction.import.io/query/extractor/7ca41326-b0fc-"
                + "40ae-a00b-921fce80468c?_apikey=ceff462760414d52af112b73128da449f3f492"
                + "2e4d42f058a06b481b2476012f8cfba2fd2b41a28af96cc7ff167582dca91a7075bf1"
                + "006d5239ad18ff6de25d37489d09167a18a4caad73643414c3bc9&url=http%3A%2F%2Fdba.dk";
        
 
        System.out.println(url2 + search);

        URL obj = new URL(url2);
        
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
        
        return null;
    
    }
    
}
