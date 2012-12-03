/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.helper;

import cz.crmf.model.bo.invoicing.*;
import cz.crmf.model.dto.invoicing.*;
import java.util.Date;

/**
 *
 * @author standa
 */
public class DtoTransformerHelper {
    public static ContactDto contactDtoFactory(Contact c) {

        return new ContactDto(c.getId(), c.getName(), c.getSurname(),
                c.getStreet(), c.getNumber(), c.getZip(), c.getDistrict(),
                c.getCity(), c.getRegion(), c.getCountry(), c.getCompanyId(),
                c.getVatNo(), c.getCompany(), c.getBankAccount(),
                c.getBank(), c.getPhone(), c.getEmail(), c.getPrimaryContact(),
                customerDtoFactory(c.getCustomer()));
    }

    public static CustomerDto customerDtoFactory(Customer c) {        
        return new CustomerDto(c.getId(), c.getUsername(), c.getEmail(),
                roleDtoFactory(c.getRole())
        );
    }
    
    public static RoleDto roleDtoFactory(Role r) {        
        return new RoleDto(r.getId(), r.getRoleName(), r.getDescription());
    }

    public static OrderItemDto orderItemDtoFactory(OrderItem oi) {
        

        
        return new OrderItemDto(oi.getId(), oi.getProductName(), 
                oi.getQuantity(), oi.getUnitPrice(), oi.getVatRate(),
                oi.getCurrency(), oi.getSubtotal(), oi.getValidFrom(),
                oi.getValidUntil(), oi.getReminderDays(), 
                invoiceDtoFactory(oi.getInvoiceId()));
    }

    private static InvoiceDto invoiceDtoFactory(Invoice in) {

        return new InvoiceDto(in.getId(), in.getTotal(), in.getBookingAmount(),
                in.getIssueDate(), in.getDueDate(), 
                customerDtoFactory(in.getCustomer()),
                contactDtoFactory(in.getDeliveryContact()),
                contactDtoFactory(in.getBillingContact()),
                in.getNote(), in.getInvoicePdf()
                );
    }
}
