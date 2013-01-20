/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.bo.ticketing;

import cz.crmf.model.bo.AbstractBusinessObject;
import cz.crmf.model.bo.invoicing.User;
import cz.crmf.model.bo.monitoring.Server;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
@Entity
@Table(name = "agents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agent.findAll", query = "SELECT a FROM Agent a"),
    @NamedQuery(name = "Agent.findById", query = "SELECT a FROM Agent a WHERE a.id = :id"),
    @NamedQuery(name = "Agent.findByUsername", query = "SELECT a FROM Agent a WHERE a.username = :username"),
    @NamedQuery(name = "Agent.findByPassword", query = "SELECT a FROM Agent a WHERE a.password = :password"),
    @NamedQuery(name = "Agent.findByName", query = "SELECT a FROM Agent a WHERE a.name = :name"),
    @NamedQuery(name = "Agent.findByEmail", query = "SELECT a FROM Agent a WHERE a.email = :email"),
    @NamedQuery(name = "Agent.findByPhone", query = "SELECT a FROM Agent a WHERE a.phone = :phone"),
    @NamedQuery(name = "Agent.findBySmsNotification", query = "SELECT a FROM Agent a WHERE a.smsNotification = :smsNotification")})
public class Agent extends User {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone", length = 45)
    private String phone;
    @Column(name = "sms_notification")
    private Boolean smsNotification;
    @OneToMany(mappedBy = "agentId")
    private List<Server> serverList;
    @OneToMany(mappedBy = "agentId")
    private List<Ticket> ticketList;

    public Agent() {
    }

    public Agent(Integer id) {
        this.id = id;
    }

    public Agent(Integer id, String username, String name, String email) {
        this.id = id;
        this.username =username;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(Boolean smsNotification) {
        this.smsNotification = smsNotification;
    }

    @XmlTransient
    public List<Server> getServerList() {
        return serverList;
    }

    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
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
        if (!(object instanceof Agent)) {
            return false;
        }
        Agent other = (Agent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Agent[ id=" + id + " ]";
    }
    
}
