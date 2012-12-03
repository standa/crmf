/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;
import java.util.Date;

/**
 *
 * @author standa
 */
public class OrderItemDto extends AbstractDto {

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
    private InvoiceDto invoice;

    public OrderItemDto() {
    }

    public OrderItemDto(Integer id) {
        this.id = id;
    }

    public OrderItemDto(Integer id, String productName, int quantity, 
            float unitPrice, float vatRate, String currency, float subtotal,
            Date validFrom, Date validUntil, Integer reminderDays, InvoiceDto invoice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
        this.currency = currency;
        this.subtotal = subtotal;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.reminderDays = reminderDays;
        this.invoice = invoice;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }


    public int getQuantity() {
        return quantity;
    }


    public float getUnitPrice() {
        return unitPrice;
    }


    public float getVatRate() {
        return vatRate;
    }


    public String getCurrency() {
        return currency;
    }


    public float getSubtotal() {
        return subtotal;
    }


    public Date getValidFrom() {
        return validFrom;
    }


    public Date getValidUntil() {
        return validUntil;
    }


    public Integer getReminderDays() {
        return reminderDays;
    }


    public InvoiceDto getInvoiceId() {
        return invoice;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.OrderItem[ id=" + id + " ]";
    }
    
}
