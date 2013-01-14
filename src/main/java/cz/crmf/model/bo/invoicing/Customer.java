/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.bo.invoicing;

import cz.crmf.model.bo.AbstractBusinessObject;
import cz.crmf.model.bo.ticketing.Ticket;
import cz.crmf.provider.HashProvider;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
@Entity
@Table(name = "customers", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByUsername", query = "SELECT c FROM Customer c WHERE c.username = :username"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")})
public class Customer extends AbstractBusinessObject {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    //if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email", nullable = false, length = 100)
    private String email;    
    @Basic(optional = false)
    @Column(name = "enabled")
    private Boolean enabled = true;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Role> roleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Invoice> invoiceList;
    @OneToMany(mappedBy = "customerId")
    private List<Ticket> ticketList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Contact> contactList;

    private transient HashProvider hashProvider; //transient fields are not persisted

    public HashProvider getHashProvider() {
        return hashProvider;
    }

    public void setHashProvider(HashProvider hashProvider) {
        this.hashProvider = hashProvider;
    }    
    
    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, String username, String password, String email, List<Role> roleList) {
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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleId(List<Role> roleList) {
        this.roleList = roleList;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @XmlTransient
    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Customer[ id=" + id + " ]";
    }
    
}
