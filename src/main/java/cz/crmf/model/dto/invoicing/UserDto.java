package cz.crmf.model.dto.invoicing;

import cz.crmf.model.bo.invoicing.*;
import cz.crmf.model.bo.AbstractBusinessObject;
import cz.crmf.model.bo.ticketing.Ticket;
import cz.crmf.model.dto.ticketing.TicketDto;
import cz.crmf.provider.HashProvider;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 * DTO for the User entitiy
 * 
 * @author standa
 */
public class UserDto extends AbstractBusinessObject {

    protected String username;
    protected String password;
    protected String email;    
    private Boolean enabled = true;
    private String name;
    private String phone;
    private Boolean smsNotification = false;    
   
    
    private List<RoleDto> roleList;
    private List<InvoiceDto> invoiceList;
    private List<TicketDto> ticketList;
    private List<ContactDto> contactList;

    private transient HashProvider hashProvider; //transient fields are not persisted

    public HashProvider getHashProvider() {
        return hashProvider;
    }

    public void setHashProvider(HashProvider hashProvider) {
        this.hashProvider = hashProvider;
    }    
    
    public UserDto() {
    }

    public UserDto(Integer id) {
        this.id = id;
    }

    public UserDto(Integer id, String username, String password, String email, List<RoleDto> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleList = roleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleDto> getRoleList() {
        return roleList;
    }

    public void setRoleId(List<RoleDto> roleList) {
        this.roleList = roleList;
    }

    @XmlTransient
    public List<InvoiceDto> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<InvoiceDto> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @XmlTransient
    public List<TicketDto> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<TicketDto> ticketList) {
        this.ticketList = ticketList;
    }

    @XmlTransient
    public List<ContactDto> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactDto> contactList) {
        this.contactList = contactList;
    }
    
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDto)) {
            return false;
        }
        UserDto other = (UserDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.dto.Customer[ id=" + id + " ]";
    }
    
}
