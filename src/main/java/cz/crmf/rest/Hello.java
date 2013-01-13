/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

/**
 * Basic hello world class to test the REST is working.
 * @author standa
 */
@Component
@Path("hello")
public class Hello {
  
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@DefaultValue("No Name") @QueryParam("name") String name) {
        return "Hello "+name;               
    }
    
    @GET
    @Path("test2")
    public Response test2() {
        String result = "Hello saved: aaa";
        return Response.status(201).entity(result).build();
    }
}
