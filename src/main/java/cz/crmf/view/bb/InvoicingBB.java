/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.view.bb;

import cz.crmf.model.dto.invoicing.RoleDto;
import cz.crmf.service.InvoicingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author standa
 */
@Component("invoicingBB")
public class InvoicingBB {
    
    @Autowired
    private InvoicingService invoicingService;
    
    public List<RoleDto> getAllRoles() {
        return invoicingService.getAllRoles();
    }
    
}
