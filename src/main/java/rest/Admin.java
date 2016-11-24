package rest;

import com.google.gson.Gson;
import facades.UserFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("demoadmin")
@RolesAllowed("Admin")
public class Admin {
    private static final Gson gson = new Gson();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomething() {
        String now = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(new Date());
        return "{\"message\" : \"REST call accesible by only authenticated ADMINS\",\n" + "\"serverTime\": \"" + now + "\"}";
    }

    @Path("users")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {
   
        UserFacade fac = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));
        ArrayList userList = new ArrayList();
        for (int i = 0; i < fac.getUsers().size(); i++) {
            
            userList.add(fac.getUsers().get(i));
        }
        System.out.println(gson.toJson(userList.toString()));
        return gson.toJson(userList.toString());
    }
    @Path("delete/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") String id){
        UserFacade fac = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));
        fac.getUserByUserId(id);
        
    }
}
