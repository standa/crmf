/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;
import cz.crmf.model.dto.ticketing.TicketDto;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class CustomerDto extends AbstractDto {

    private String username;
    private String password;
    private String email;
    private int roleId;
    private RoleDto role;
    private List<InvoiceDto> invoiceList;
    private List<TicketDto> ticketList;
    private List<ContactDto> contactList;

    public CustomerDto(Integer id, String username, String email, int roleId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roleId = roleId;
    }

    public CustomerDto(Integer id, String username, String email, RoleDto role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
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

    public int getRoleId() {
        return roleId;
    }

    public RoleDto getRole() {
        return role;
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


    @Override
    public String toString() {
        return "cz.crmf.bo.Customer[ id=" + id + " ]";
    }
    
}
