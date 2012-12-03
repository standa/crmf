/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class InvoiceDto extends AbstractDto {
    private float total;
    private Float bookingAmount;
    private Date issueDate;
    private Date dueDate;
    private String note;
    private byte[] invoicePdf;
    private List<OrderItemDto> orderItemList;
    private ContactDto deliveryContact;
    private ContactDto billingContact;
    private CustomerDto customer;

    public InvoiceDto(Integer id, float total, float bookingAmount, 
            Date issueDate, Date dueDate) {
        this.id = id;
        this.total = total;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }
    
    public InvoiceDto(Integer id, float total, float bookingAmount,
            Date issueDate, Date dueDate, CustomerDto customer,
            ContactDto deliveryContact, ContactDto billingContact, 
            String note, byte[] invoicePdf) {
        this.id = id;
        this.total = total;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.deliveryContact = deliveryContact;
        this.billingContact = billingContact;
        this.customer = customer;
    }    

    public float getTotal() {
        return total;
    }


    public Float getBookingAmount() {
        return bookingAmount;
    }
    
    public Date getIssueDate() {
        return issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getNote() {
        return note;
    }

    public byte[] getInvoicePdf() {
        return invoicePdf;
    }

    @XmlTransient
    public List<OrderItemDto> getOrderItemList() {
        return orderItemList;
    }

    public ContactDto getDeliveryContact() {
        return deliveryContact;
    }

    public ContactDto getBillingContact() {
        return billingContact;
    }

    public CustomerDto getCustomerId() {
        return customer;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Invoice[ id=" + id + " ]";
    }
    
}
