package cz.crmf.view.bb;

import cz.crmf.model.bo.invoicing.*;
import cz.crmf.model.dto.invoicing.*;
import cz.crmf.model.helper.DtoTransformerHelper;
import cz.crmf.model.repositories.invoicing.RoleRepository;
import cz.crmf.service.iface.AbstractDataAccessService;
import cz.crmf.service.iface.InvoicingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Reference implementation for the invoicing service used by JSF pages.
 * 
 * @author standa
 */
@Service("invoicingService")
@Scope("application")
public class InvoicingServiceImpl extends AbstractDataAccessService 
    implements InvoicingService {
    
    @Autowired
    RoleRepository roleRepository;

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
        
        User customer = getGenericDao().getById(customerId, User.class);
        
        Contact c = getGenericDao().saveOrUpdate(
                new Contact(name, surname, street, number, zip, district, 
                city, region, country, companyId, vatNo, company,
                bankAccount, bank, phone, email, primaryContact, 
                customer));
        
               
//        CustomerDto custDto = new CustomerDto(
//                customer.getId(), customer.getUsername(), customer.getEmail(), 
//                new RoleDto(
//                    customer.getRole().getId(), 
//                    customer.getRole().getRoleName(),
//                    customer.getRole().getDescription()
//                )
//        );
        
        ContactDto dto = DtoTransformerHelper.contactDtoFactory(c);
        
        return dto;
    }

    @Override
    public ContactDto getContactByID(Integer contactId) {
        return getModelMapper().map(getGenericDao()
                .getById(contactId, Contact.class), ContactDto.class);
    }

    @Override
    public void deleteContact(Integer contactId) {
        getGenericDao().removeById(contactId, Contact.class);
    }

    @Override
    public Integer createCustomer(String username, String password, 
        String email) {
        
        List<RoleDto> roles = new ArrayList<RoleDto>();
        roles.add(getModelMapper().map(roleRepository.getRoleByRoleName("CUSTOMER"), RoleDto.class));
        
        return getGenericDao().saveOrUpdate(
            getModelMapper().map(
                new CustomerDto(username, password, email, roles), User.class
            )
        ).getId();
                
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        return getModelMapper().map(getGenericDao().getById(customerId, User.class), CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        getGenericDao().removeById(customerId, User.class);
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
        throw new UnsupportedOperationException();    
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

    @Override
    public boolean checkUsername(String username) {        
        return !getGenericDao().existsByProperty("username", username, User.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> dtos = new ArrayList<CustomerDto>();
        
        for (User u : getGenericDao().getAllOrderedDesc("id", User.class)) {
            dtos.add(getModelMapper().map(u, CustomerDto.class));
        }
        
        return dtos;
    }

    @Override
    public List<CustomerDto> getLast5Customers() {
        List<CustomerDto> dtos = new ArrayList<CustomerDto>();
        
        for (User u : getGenericDao().getPage(1, 5, "id", false, User.class)) {
            dtos.add(getModelMapper().map(u, CustomerDto.class));
        }
        
        return dtos;
    }

    
}
