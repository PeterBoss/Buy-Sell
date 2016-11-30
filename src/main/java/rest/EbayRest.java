/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ebay.Ebay;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Peter
 */
@Path("ebaysearch")
public class EbayRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public EbayRest() {
    }

    /**
     * Retrieves representation of an instance of ebay.EbayRest
     * @param keyword
     * @return an instance of java.lang.String
     * @throws java.io.IOException
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{keyword}")
    public String getXml(@PathParam("keyword") String keyword) throws IOException {

        Ebay ebay = new Ebay();
        
        System.out.println("tests");
        
        return ebay.findByKeywords(keyword);

    }

    /**
     * PUT method for updating or creating an instance of EbayRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
