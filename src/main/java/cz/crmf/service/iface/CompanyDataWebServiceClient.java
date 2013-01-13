package cz.crmf.service.iface;

import cz.crmf.model.dto.invoicing.ContactDto;
import cz.crmf.service.impl.AresWebService;

/**
 * This class is intented to manage the situations when governments offer
 * public database access via various kinds of web services. There is 
 * a reference implementation for the Czech ARES web service.
 * 
 * @see AresWebService
 * @author standa
 */
public interface CompanyDataWebServiceClient {
    public ContactDto getContactDtoByRegNo(String regNo);
}
