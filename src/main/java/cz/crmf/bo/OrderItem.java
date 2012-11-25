/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author standa
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),
    @NamedQuery(name = "OrderItem.findByOrderId", query = "SELECT o FROM OrderItem o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderItem.findByProductName", query = "SELECT o FROM OrderItem o WHERE o.productName = :productName"),
    @NamedQuery(name = "OrderItem.findByDescription", query = "SELECT o FROM OrderItem o WHERE o.description = :description"),
    @NamedQuery(name = "OrderItem.findByQuantity", query = "SELECT o FROM OrderItem o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderItem.findByUnitPrice", query = "SELECT o FROM OrderItem o WHERE o.unitPrice = :unitPrice"),
    @NamedQuery(name = "OrderItem.findByVatRate", query = "SELECT o FROM OrderItem o WHERE o.vatRate = :vatRate"),
    @NamedQuery(name = "OrderItem.findByCurrency", query = "SELECT o FROM OrderItem o WHERE o.currency = :currency"),
    @NamedQuery(name = "OrderItem.findBySubtotal", query = "SELECT o FROM OrderItem o WHERE o.subtotal = :subtotal"),
    @NamedQuery(name = "OrderItem.findByValidFrom", query = "SELECT o FROM OrderItem o WHERE o.validFrom = :validFrom"),
    @NamedQuery(name = "OrderItem.findByValidUntil", query = "SELECT o FROM OrderItem o WHERE o.validUntil = :validUntil"),
    @NamedQuery(name = "OrderItem.findByReminderDays", query = "SELECT o FROM OrderItem o WHERE o.reminderDays = :reminderDays")})
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;
    @Size(max = 200)
    @Column(name = "description", length = 200)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price", nullable = false)
    private float unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vat_rate", nullable = false)
    private float vatRate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "currency", nullable = false, length = 10)
    private String currency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal", nullable = false)
    private float subtotal;
    @Column(name = "valid_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;
    @Column(name = "valid_until")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validUntil;
    @Column(name = "reminder_days")
    private Integer reminderDays;
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id", nullable = false)
    @ManyToOne(optional = false)
    private Invoice invoiceId;

    public OrderItem() {
    }

    public OrderItem(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderItem(Integer orderId, String productName, int quantity, float unitPrice, float vatRate, String currency, float subtotal) {
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

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
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
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
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
