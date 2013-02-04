package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;
import cz.crmf.model.dto.ticketing.TicketDto;
import cz.crmf.provider.HashProvider;
import cz.crmf.provider.SHA1Provider;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Register a new customer. 
 * A customer is in fact a user with the role 'CUSTOMER'.
 * 
 * @author standa
 */
public class CustomerDto extends AbstractDto {

    private String username;
    private String password;
    private String email;
    private List<RoleDto> roleList;
    private List<InvoiceDto> invoiceList;
    private List<TicketDto> ticketList;
    private List<ContactDto> contactList;
    
    public CustomerDto(Integer id, String username, String email, List<RoleDto> roleList) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roleList = roleList;
    }

    /**
     * Constructor for creating new customer entities.
     * 
     * @param username
     * @param password the password is automatically hashed via SHA1Provider
     * @param email
     * @param roleList 
     */
    public CustomerDto(String username, String password, String email, List<RoleDto> roleList) {
        this.username = username;
        HashProvider hash = new SHA1Provider();
        this.password = hash.computeHash(password);
        this.email = email;
        this.roleList = roleList;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public List<RoleDto> getRoleList() {
        return roleList;
    }

    @XmlTransient
    public List<InvoiceDto> getInvoiceList() {
        return invoiceList;
    }

    @XmlTransient
    public List<TicketDto> getTicketList() {
        return ticketList;
    }

    @XmlTransient
    public List<ContactDto> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactDto> contactList) {
        this.contactList = contactList;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInvoiceList(List<InvoiceDto> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleList(List<RoleDto> roleList) {
        this.roleList = roleList;
    }

    public void setTicketList(List<TicketDto> ticketList) {
        this.ticketList = ticketList;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString() {
        return "cz.crmf.bo.Customer[ id=" + id + " ]";
    }
    
}
