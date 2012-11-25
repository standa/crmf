/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class InvoiceDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer invoiceId;
    private float total;
    private Float bookingAmount;
    private Date issueDate;
    private Date dueDate;
    private String note;
    private byte[] invoicePdf;
    private List<OrderItemDto> orderItemList;
    private CustomerDto customerId;
    private ContactDto deliveryContact;
    private ContactDto billingContact;

    public InvoiceDto() {
    }

    public InvoiceDto(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceDto(Integer invoiceId, float total, Date issueDate, Date dueDate) {
        this.invoiceId = invoiceId;
        this.total = total;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Float getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Float bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte[] getInvoicePdf() {
        return invoicePdf;
    }

    public void setInvoicePdf(byte[] invoicePdf) {
        this.invoicePdf = invoicePdf;
    }

    @XmlTransient
    public List<OrderItemDto> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemDto> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public CustomerDto getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerDto customerId) {
        this.customerId = customerId;
    }

    public ContactDto getDeliveryContact() {
        return deliveryContact;
    }

    public void setDeliveryContact(ContactDto deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    public ContactDto getBillingContact() {
        return billingContact;
    }

    public void setBillingContact(ContactDto billingContact) {
        this.billingContact = billingContact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceDto)) {
            return false;
        }
        InvoiceDto other = (InvoiceDto) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Invoice[ invoiceId=" + invoiceId + " ]";
    }
    
}