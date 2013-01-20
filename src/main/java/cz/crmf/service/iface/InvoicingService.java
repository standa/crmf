/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.service.iface;

import cz.crmf.model.dto.invoicing.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author standa
 */
public interface InvoicingService {
    
    // roles

    public Integer createRole(String roleName, String description);
    public List<RoleDto> getAllRoles();
    public RoleDto getRoleById(Integer roleId);    
    public void deleteRole(Integer roleId);

    // contacts
    public ContactDto createContact(String name, String surname, String street, 
        String number, String zip, String district, String city, String region, 
        String country, String companyId, String vatNo, String company, 
        String bankAccount, String bank, String phone, String email, 
        Boolean primaryContact, Integer customerId);
    public ContactDto getContactByID(Integer contactId);
    public void deleteContact(Integer contactId);

    // customers
    public Integer createCustomer(String username, String password, String email, Integer roleId);
    public CustomerDto getCustomerById(Integer customerId);
    public void deleteCustomer(Integer customerId);
    public List<CustomerDto> getAllCustomers();
    public List<CustomerDto> getLast5Customers();

    // invoices
    public Integer createInvoice(float total, float bookingAmount, 
        Date issueDate, Date dueDate, Integer customerId, Integer billingContact, 
        Integer deliveryContact, String note, byte[] invoicePdf);
    public List<InvoiceDto> getInvoicesByCustomerId(Integer customerId);
    public void deleteInvoice(Integer invoiceId);
    public OrderItemDto createOrderItem(Integer invoiceId, String productName,
        String description, Integer quantity, Float unitPrice, Float vatRate, 
        String currency, Float subtotal, Date validFrom,
        Date validUntil, Integer reminderDays);    
    public void deleteOrderItem(Integer orderItemId);

    /**
     * check if the username exists in the database already
     * @param username the desired username
     * @return true if the username is free to register, false otherwise
     */
    public boolean checkUsername(String username);
    
    
    
}
