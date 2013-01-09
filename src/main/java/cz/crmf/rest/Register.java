/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.stereotype.Component;

/**
 *
 * @author standa
 */
@Component
@Path("/register")
public class Register {
    
    
    
    @GET
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    public Response check(@QueryParam("username") String username) {
        Boolean a = false;
        if (a) {
            return Response.ok().build();
        } else {
            return Response.status(Status.CONFLICT).build();
        }        
    }
    
}
