package cz.crmf.service.iface;

/**
 * This interface downloads and processes data using external domain provider
 * web service. The aim of this interface is to provide universal access point
 * to the domain services like: whois, register new domain, update domain, etc.
 * 
 * @author standa
 */
public interface DomainDataWebServiceClient {
    
    public boolean checkDomain(String domain);
    
}
