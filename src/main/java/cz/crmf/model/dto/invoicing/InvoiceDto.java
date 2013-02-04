package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents one invoice for a particular order. Each invoice has 
 * some OrderItems.
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

    public void setBillingContact(ContactDto billingContact) {
        this.billingContact = billingContact;
    }

    public void setBookingAmount(Float bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public void setDeliveryContact(ContactDto deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setInvoicePdf(byte[] invoicePdf) {
        this.invoicePdf = invoicePdf;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setOrderItemList(List<OrderItemDto> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    

    @Override
    public String toString() {
        return "cz.crmf.bo.Invoice[ id=" + id + " ]";
    }
    
}
