/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    
}
