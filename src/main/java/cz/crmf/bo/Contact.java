/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.bo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
@Entity
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByContactId", query = "SELECT c FROM Contact c WHERE c.contactId = :contactId"),
    @NamedQuery(name = "Contact.findByName", query = "SELECT c FROM Contact c WHERE c.name = :name"),
    @NamedQuery(name = "Contact.findBySurname", query = "SELECT c FROM Contact c WHERE c.surname = :surname"),
    @NamedQuery(name = "Contact.findByStreet", query = "SELECT c FROM Contact c WHERE c.street = :street"),
    @NamedQuery(name = "Contact.findByNumber", query = "SELECT c FROM Contact c WHERE c.number = :number"),
    @NamedQuery(name = "Contact.findByZip", query = "SELECT c FROM Contact c WHERE c.zip = :zip"),
    @NamedQuery(name = "Contact.findByDistrict", query = "SELECT c FROM Contact c WHERE c.district = :district"),
    @NamedQuery(name = "Contact.findByCity", query = "SELECT c FROM Contact c WHERE c.city = :city"),
    @NamedQuery(name = "Contact.findByRegion", query = "SELECT c FROM Contact c WHERE c.region = :region"),
    @NamedQuery(name = "Contact.findByCountry", query = "SELECT c FROM Contact c WHERE c.country = :country"),
    @NamedQuery(name = "Contact.findByCompanyId", query = "SELECT c FROM Contact c WHERE c.companyId = :companyId"),
    @NamedQuery(name = "Contact.findByVatNo", query = "SELECT c FROM Contact c WHERE c.vatNo = :vatNo"),
    @NamedQuery(name = "Contact.findByCompany", query = "SELECT c FROM Contact c WHERE c.company = :company"),
    @NamedQuery(name = "Contact.findByBankAccount", query = "SELECT c FROM Contact c WHERE c.bankAccount = :bankAccount"),
    @NamedQuery(name = "Contact.findByBank", query = "SELECT c FROM Contact c WHERE c.bank = :bank"),
    @NamedQuery(name = "Contact.findByIban", query = "SELECT c FROM Contact c WHERE c.iban = :iban"),
    @NamedQuery(name = "Contact.findBySwiftBic", query = "SELECT c FROM Contact c WHERE c.swiftBic = :swiftBic"),
    @NamedQuery(name = "Contact.findByPhone", query = "SELECT c FROM Contact c WHERE c.phone = :phone"),
    @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email"),
    @NamedQuery(name = "Contact.findByPrimaryContact", query = "SELECT c FROM Contact c WHERE c.primaryContact = :primaryContact")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "contact_id", nullable = false)
    private Integer contactId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Size(max = 45)
    @Column(name = "surname", length = 45)
    private String surname;
    @Size(max = 100)
    @Column(name = "street", length = 100)
    private String street;
    @Size(max = 45)
    @Column(name = "number", length = 45)
    private String number;
    @Size(max = 45)
    @Column(name = "zip", length = 45)
    private String zip;
    @Size(max = 45)
    @Column(name = "district", length = 45)
    private String district;
    @Size(max = 45)
    @Column(name = "city", length = 45)
    private String city;
    @Size(max = 45)
    @Column(name = "region", length = 45)
    private String region;
    @Size(max = 45)
    @Column(name = "country", length = 45)
    private String country;
    @Size(max = 45)
    @Column(name = "company_id", length = 45)
    private String companyId;
    @Size(max = 45)
    @Column(name = "vat_no", length = 45)
    private String vatNo;
    @Size(max = 250)
    @Column(name = "company", length = 250)
    private String company;
    @Size(max = 45)
    @Column(name = "bank_account", length = 45)
    private String bankAccount;
    @Size(max = 45)
    @Column(name = "bank", length = 45)
    private String bank;
    @Size(max = 45)
    @Column(name = "iban", length = 45)
    private String iban;
    @Size(max = 45)
    @Column(name = "swift_bic", length = 45)
    private String swiftBic;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone", length = 45)
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email", length = 45)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "primary_contact", nullable = false)
    private boolean primaryContact;
    @OneToMany(mappedBy = "deliveryContact")
    private List<Invoice> invoiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingContact")
    private List<Invoice> invoiceList1;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerId;

    public Contact() {
    }

    public Contact(Integer contactId) {
        this.contactId = contactId;
    }

    public Contact(Integer contactId, String name, boolean primaryContact) {
        this.contactId = contactId;
        this.name = name;
        this.primaryContact = primaryContact;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSwiftBic() {
        return swiftBic;
    }

    public void setSwiftBic(String swiftBic) {
        this.swiftBic = swiftBic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(boolean primaryContact) {
        this.primaryContact = primaryContact;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList1() {
        return invoiceList1;
    }

    public void setInvoiceList1(List<Invoice> invoiceList1) {
        this.invoiceList1 = invoiceList1;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cz.crmf.bo.Contact[ contactId=" + contactId + " ]";
    }
    
}
