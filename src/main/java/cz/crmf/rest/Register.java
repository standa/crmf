package cz.crmf.rest;

import cz.crmf.model.dto.invoicing.ContactDto;
import cz.crmf.service.iface.CompanyDataWebServiceClient;
import cz.crmf.service.iface.DomainDataWebServiceClient;
import cz.crmf.service.iface.InvoicingService;
import java.util.Locale;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
    
    @Autowired
    InvoicingService invoicingService;
    
    @Autowired
    CompanyDataWebServiceClient companyDataService;
    
    @Autowired
    DomainDataWebServiceClient domainDataService;
    
    // use as messages.getMessage("key", new Object[] {val1, val2}, Locale.ENGLISH)
    @Autowired
    MessageSource messages;
    
    @GET
    @Path("/check/domain/{domain}")
    @Produces(MediaType.APPLICATION_JSON)
    public Result checkDomain(@PathParam("domain") String domain) {
        
        if (domainDataService.checkDomain(domain)) {
            return new Result(domain);
        } else {
            return new Result(false, ResultCode.CONFLICT);
        }
    }
    
    @GET
    @Path("/check/username/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Result checkUsername(@PathParam("username") String username) {
        if (invoicingService.checkUsername(username)) {
            return new Result();
        } else {            
            return new Result(false, ResultCode.CONFLICT);
        }
    }
    
    /**
     * lookup a company knowing its ICO from the ARES public database
     * of the ministery of finance of the Czech Republic
     * 
     * example URL: http://localhost:8080/rest/register/aresLookup/27074358
     * 
     * @param ico
     * @return 
     */
    @GET
    @Path("/lookupCompany/{ico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Result lookupCompany(@PathParam("ico") String ico) {        
        ContactDto dto = companyDataService.getContactDtoByRegNo(ico);
        
        if (dto == null) {
            return new Result(false, ResultCode.NOT_FOUND);
        } else {
            return new Result(dto);
        }
    }
    
}
