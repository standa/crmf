/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.service.impl;

import cz.crmf.model.bo.invoicing.*;
import cz.crmf.model.dto.invoicing.*;
import cz.crmf.model.helper.DtoTransformerHelper;
import cz.crmf.model.service.AbstractDataAccessService;
import cz.crmf.model.service.InvoicingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author standa
 */
@Service
public class InvoicingServiceImpl extends AbstractDataAccessService 
    implements InvoicingService {

    @Override
    public Integer createRole(String roleName, String description) {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setDescription(description);
        return getGenericDao().saveOrUpdate(role).getId();
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<RoleDto> roles = new ArrayList<RoleDto>();
        for (Role r : getGenericDao().getAll(Role.class)) {
            RoleDto dto = new RoleDto(r.getId(), r.getRoleName(),
                    r.getDescription());
            roles.add(dto);
        }
        return roles;
    }

    @Override
    public RoleDto getRoleById(Integer roleId) {
        Role role = getGenericDao().getById(roleId, Role.class);
        return new RoleDto(role.getId(), role.getRoleName(), role.getDescription());
    }

    @Override
    public void deleteRole(Integer roleId) {
        getGenericDao().removeById(roleId, Role.class);
    }

    @Override
    public ContactDto createContact(String name, String surname, String street, 
        String number, String zip, String district, String city, String region, 
        String country, String companyId, String vatNo, String company, 
        String bankAccount, String bank, String phone, String email, 
        Boolean primaryContact, Integer customerId) {        
        
        Customer customer = getGenericDao().getById(customerId, Customer.class);
        
        Contact c = getGenericDao().saveOrUpdate(
                new Contact(name, surname, street, number, zip, district, 
                city, region, country, companyId, vatNo, company,
                bankAccount, bank, phone, email, primaryContact, 
                customer));
        
               
        CustomerDto custDto = new CustomerDto(
                customer.getId(), customer.getUsername(), customer.getEmail(), 
                new RoleDto(
                    customer.getRole().getId(), 
                    customer.getRole().getRoleName(),
                    customer.getRole().getDescription()
                )
        );
        
        ContactDto dto = DtoTransformerHelper.contactDtoFactory(c);
        
        return dto;
    }

    @Override
    public ContactDto getContactByID(Integer contactId) {
        
        Contact c = getGenericDao().getById(contactId, Contact.class);
        
        Customer customer = c.getCustomer();
        
        CustomerDto custDto = new CustomerDto(
                customer.getId(), customer.getUsername(), customer.getEmail(), 
                new RoleDto(
                    customer.getRole().getId(), 
                    customer.getRole().getRoleName(),
                    customer.getRole().getDescription()
                )
        );
        
        ContactDto dto = DtoTransformerHelper.contactDtoFactory(c);
        
        return dto;        
    }

    @Override
    public void deleteContact(Integer contactId) {
        getGenericDao().removeById(contactId, Contact.class);
    }

    @Override
    public Integer createCustomer(String username, String password, 
        String email, Integer roleId) {
        
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setRoleId(roleId);
        
        return getGenericDao().saveOrUpdate(customer).getId();        
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        Customer c = getGenericDao().getById(customerId, Customer.class);
        return new CustomerDto(c.getId(), c.getUsername(), c.getEmail(), c.getRoleId());
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        getGenericDao().removeById(customerId, Customer.class);
    }

    @Override
    public Integer createInvoice(float total, float bookingAmount, 
        Date issueDate, Date dueDate, Integer customerId, Integer billingContact, 
        Integer deliveryContact, String note, byte[] invoicePdf) {
        
        Invoice in = new Invoice();
        in.setTotal(total);
        in.setBookingAmount(bookingAmount);
        in.setIssueDate(issueDate);
        in.setDueDate(dueDate);
        in.setBillingContact(getGenericDao().getById(billingContact, Contact.class));
        in.setBillingContact(getGenericDao().getById(deliveryContact, Contact.class));
        in.setNote(note);
        in.setInvoicePdf(invoicePdf);
        
        return getGenericDao().saveOrUpdate(in).getId();
    }

    @Override
    public List<InvoiceDto> getInvoicesByCustomerId(Integer customerId) {
        List<InvoiceDto> dtos = new ArrayList<InvoiceDto>();
        for (Invoice in: getGenericDao().getByProperty("id", customerId, Invoice.class)) {
/*
 *     public InvoiceDto(Integer id, float total, float bookingAmount,
            Date issueDate, Date dueDate, CustomerDto customer,
            ContactDto deliveryContact, ContactDto billingContact, 
            String note, byte[] invoicePdf) {
 */
            
            InvoiceDto dto = new InvoiceDto(in.getId(), in.getTotal(),
                    in.getBookingAmount(),
                    in.getIssueDate(), in.getDueDate(), 
                    DtoTransformerHelper.customerDtoFactory(in.getCustomer()),
                    DtoTransformerHelper.contactDtoFactory(in.getBillingContact()), 
                    DtoTransformerHelper.contactDtoFactory(in.getDeliveryContact()),                     
                    in.getNote(), in.getInvoicePdf());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void deleteInvoice(Integer invoiceId) {
       getGenericDao().removeById(invoiceId, Invoice.class);
    }

    @Override
    public OrderItemDto createOrderItem(Integer invoiceId, String productName,
        String description, Integer quantity, Float unitPrice, Float vatRate, 
        String currency, Float subtotal, Date validFrom,
        Date validUntil, Integer reminderDays) {
        
        OrderItem oi = new OrderItem();
        oi.setInvoiceId(getGenericDao().getById(invoiceId, Invoice.class));
        oi.setProductName(productName);
        oi.setDescription(description);
        oi.setQuantity(quantity);
        oi.setUnitPrice(unitPrice);
        oi.setVatRate(vatRate);
        oi.setCurrency(currency);
        oi.setSubtotal(subtotal);
        oi.setValidFrom(validFrom);
        oi.setValidUntil(validUntil);
        oi.setReminderDays(reminderDays);
        
        getGenericDao().saveOrUpdate(oi);
        
        return DtoTransformerHelper.orderItemDtoFactory(oi);
        
    }

    @Override
    public void deleteOrderItem(Integer orderItemId) {
        getGenericDao().removeById(orderItemId, OrderItem.class);
    }

    
}
