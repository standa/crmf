package cz.crmf.view.bb;

import cz.crmf.model.bo.invoicing.Role;
import cz.crmf.model.bo.invoicing.User;
import cz.crmf.model.dao.GenericDao;
import cz.crmf.model.dto.invoicing.UserDto;
import cz.crmf.model.repositories.invoicing.RoleRepository;
import cz.crmf.model.repositories.invoicing.UserRepository;
import cz.crmf.provider.HashProvider;
import cz.crmf.provider.SHA1Provider;
import cz.crmf.view.helper.FacesUtil;
import java.io.Serializable;
import java.util.Arrays;
import javax.faces.application.FacesMessage;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * JSF2 backing bean implementation for the register service
 * 
 * @author standa
 */
@Scope("request")
@Component("registerBean")
public class RegisterBean implements Serializable {

    private UserDto user;
    
    private String roleName = "CUSTOMER";
    
    public static final String roles[] = {"CUSTOMER", "AGENT", "ADMIN"};
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private GenericDao genericDao;
    
    private ModelMapper modelMapper = new ModelMapper();
    
    public void checkUsername(AjaxBehaviorEvent event) {        
        if (genericDao.existsByProperty("username", user.getUsername(), User.class)) {
            FacesMessage msg =
                    new FacesMessage(
                        FacesUtil.getMessage("cz.crmf.server", "register.userAlreadyExists"),
                        FacesUtil.getMessage("cz.crmf.server", "register.userAlreadyExists"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);            
        }
    }

    public void registerUser() {
        
        Role role = new Role();
        role.setRoleName(roleName);
        
        User u = modelMapper.map(user, User.class);
        
        u.setRoleList(Arrays.asList(role));
        
        HashProvider hashProvider = new SHA1Provider();
        
        u.setPassword(hashProvider.computeHash(user.getPassword()));
                
        userRepository.save(u);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
    
    
    
}
