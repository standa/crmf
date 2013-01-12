package cz.crmf.rest;

import cz.crmf.model.dto.invoicing.ContactDto;
import cz.crmf.service.iface.CompanyDataWebServiceClient;
import cz.crmf.service.impl.AresWebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.stereotype.Component;

/**
 * the controller of the registraion process
 * 
 * this one is meant to check the username uniqueness, domain existence,
 * load data from the governmental registers etc.
 * @author standa
 */
@Component
@Path("/register")
public class Register {
    
    @GET
    @Path("/check/domain/{domain}")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkDomain(@PathParam("domain") String domain) {
        return "checking domain "+domain;
    }
    
    @GET
    @Path("/check/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUsername(@PathParam("username") String username) {
        Boolean a = false;
        if (a) {
            return Response.ok().build();
        } else {
            return Response.status(Status.CONFLICT).build();
        }        
    }
    
    /**
     * lookup a company knowing its ICO from the ARES public database
     * of the ministery of finance of the Czech Republic
     * @param ico
     * @return 
     */
    @GET
    @Path("/aresLookup/{ico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Result aresLookup(@PathParam("ico") String ico) {
        CompanyDataWebServiceClient ws = new AresWebService();
        ContactDto dto = ws.getContactDtoByRegNo(ico);
        
        if (dto == null) {
            return new Result(false, ResultCode.NOT_EXIST);
        } else {
            return new Result(dto);
        }
    }
    
}
