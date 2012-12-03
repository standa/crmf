/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.service;

import cz.crmf.model.bo.invoicing.Contact;
import cz.crmf.model.bo.invoicing.OrderItem;
import cz.crmf.model.bo.invoicing.Role;
import cz.crmf.model.dto.invoicing.ContactDto;

/**
 *
 * @author standa
 */
public interface InvoicingService {

    public Role createRole();
    public void deleteRole(Integer roleId);

    public Contact createContact(ContactDto contact);
    public void deleteContact(Integer contactId);

    public Integer createCustomer();
    public void deleteCustomer(Integer customerId);

    public Integer createInvoice();
    public void deleteInvoice(Integer invoiceId);
    public OrderItem createOrderItem();
    public void deleteOrderItem(Integer orderItemId);
    
    
    
}
