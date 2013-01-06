/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.bo.invoicing;

import cz.crmf.model.bo.AbstractBusinessObject;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author standa
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),
    @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName"),
    @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")})
public class Role extends AbstractBusinessObject {
    
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Customer customer;
    @Size(max = 20)
    @Column(name = "role_name", length = 20)
    private String roleName;
    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;    

    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Role[ id=" + id + " ]";
    }
    
}
