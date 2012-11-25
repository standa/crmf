/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author standa
 */
public class OrderItemDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orderId;
    private String productName;
    private String description;
    private int quantity;
    private float unitPrice;
    private float vatRate;
    private String currency;
    private float subtotal;
    private Date validFrom;
    private Date validUntil;
    private Integer reminderDays;
    private InvoiceDto invoiceId;

    public OrderItemDto() {
    }

    public OrderItemDto(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderItemDto(Integer orderId, String productName, int quantity, float unitPrice, float vatRate, String currency, float subtotal) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
        this.currency = currency;
        this.subtotal = subtotal;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getVatRate() {
        return vatRate;
    }

    public void setVatRate(float vatRate) {
        this.vatRate = vatRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getReminderDays() {
        return reminderDays;
    }

    public void setReminderDays(Integer reminderDays) {
        this.reminderDays = reminderDays;
    }

    public InvoiceDto getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(InvoiceDto invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItemDto)) {
            return false;
        }
        OrderItemDto other = (OrderItemDto) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.OrderItem[ orderId=" + orderId + " ]";
    }
    
}
