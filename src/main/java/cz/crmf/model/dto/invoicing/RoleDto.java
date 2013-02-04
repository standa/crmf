package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;

/**
 * User roles. Every user can have multiple roles.
 * 
 * @author standa
 */
public class RoleDto extends AbstractDto {

    private String roleName;
    private String description;
    private String username;
    private UserDto customer;
    
    public RoleDto(Integer id, String username, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.username = username;
        this.description = description;
    }

    public RoleDto(Integer id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }
    
    public RoleDto(Integer id, String roleName, String description, UserDto user) {
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
    
    public UserDto getUser() {
        return customer;
    }

    public void setUser(UserDto customer) {
        this.customer = customer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    @Override
    public String toString() {
        return "cz.crmf.bo.Role[ id=" + id + " ]";
    }
    
}
