/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class RoleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String roleName;
    private String description;
    private List<CustomerDto> customerList;

    public RoleDto() {
    }

    public RoleDto(String roleName) {
        this.roleName = roleName;
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

    @XmlTransient
    public List<CustomerDto> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerDto> customerList) {
        this.customerList = customerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleName != null ? roleName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleDto)) {
            return false;
        }
        RoleDto other = (RoleDto) object;
        if ((this.roleName == null && other.roleName != null) || (this.roleName != null && !this.roleName.equals(other.roleName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Role[ roleName=" + roleName + " ]";
    }
    
}
