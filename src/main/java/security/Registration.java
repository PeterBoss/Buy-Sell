/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import facades.UserFacade;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Peter
 */
@Path("registration")
public class Registration {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegistrationResource
     */
    public Registration() {
    }

    /**
     * Retrieves representation of an instance of entity.Registration
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Registration
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(String jsonString) {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String username = json.get("username").getAsString();
        String password = json.get("password").getAsString();
        
        UserFacade fac = new UserFacade(Persistence.createEntityManagerFactory("buysell"));
        
        fac.createUser(username, password);
        
    }
}
