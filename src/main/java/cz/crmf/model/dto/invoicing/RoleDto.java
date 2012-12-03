/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;

/**
 *
 * @author standa
 */
public class RoleDto extends AbstractDto {

    private String roleName;
    private String description;
    private CustomerDto customer;

    public RoleDto(Integer id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }
    
    public RoleDto(Integer id, String roleName, String description, CustomerDto customer) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
        this.customer = customer;
    }    

    public String getRoleName() {
        return roleName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public CustomerDto getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Role[ id=" + id + " ]";
    }
    
}
