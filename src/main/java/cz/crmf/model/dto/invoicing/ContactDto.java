/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.dto.invoicing;

import cz.crmf.model.dto.AbstractDto;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author standa
 */
public class ContactDto extends AbstractDto {

    private String name;
    private String surname;
    private String street;
    private String number;
    private String zip;
    private String district;
    private String city;
    private String region;
    private String country;
    private String companyId;
    private String vatNo;
    private String company;
    private String bankAccount;
    private String bank;
    private String iban;
    private String swiftBic;
    private String phone;
    private String email;
    private boolean primaryContact;
    private List<InvoiceDto> invoiceList;
    private CustomerDto customer;

    /**
     * a full stack constructor used for database communication
     * 
     * @param id
     * @param name
     * @param surname
     * @param street
     * @param number
     * @param zip
     * @param district
     * @param city
     * @param region
     * @param country
     * @param companyId
     * @param vatNo
     * @param company
     * @param bankAccount
     * @param bank
     * @param phone
     * @param email
     * @param primaryContact
     * @param customer 
     */
    public ContactDto(Integer id, String name, String surname, String street, String number, 
            String zip, String district, String city, String region, 
            String country, String companyId, String vatNo, String company, 
            String bankAccount, String bank, String phone, String email, 
            Boolean primaryContact, CustomerDto customer) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.district = district;
        this.city = city;
        this.region = region;
        this.country = country;
        this.companyId = companyId;
        this.vatNo = vatNo;
        this.company = company;
        this.bankAccount = bankAccount;
        this.bank = bank;
        this.phone = phone;
        this.email = email;
        this.primaryContact = primaryContact;
        this.customer = customer;
    }
    
    /**
     * DTO specific for company contact registrations:
     * - the contact person may not be known, as well as other details
     * but still many records can be found out just by knowing the company
     * registration number
     * 
     * @param street
     * @param number
     * @param zip
     * @param district
     * @param city
     * @param region
     * @param country
     * @param companyId
     * @param vatNo
     * @param company 
     */
    public ContactDto(String street, String number, 
            String zip, String district, String city, String region, 
            String country, String companyId, String vatNo, String company
            ) {
        
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.district = district;
        this.city = city;
        this.region = region;
        this.country = country;
        this.companyId = companyId;
        this.vatNo = vatNo;
        this.company = company;
        
    }

    public ContactDto(Integer id, String name, boolean primaryContact) {
        this.id = id;
        this.name = name;
        this.primaryContact = primaryContact;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZip() {
        return zip;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }


    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }


    public String getCompanyId() {
        return companyId;
    }


    public String getVatNo() {
        return vatNo;
    }


    public String getCompany() {
        return company;
    }


    public String getBankAccount() {
        return bankAccount;
    }


    public String getBank() {
        return bank;
    }


    public String getIban() {
        return iban;
    }


    public String getSwiftBic() {
        return swiftBic;
    }


    public String getPhone() {
        return phone;
    }


    public String getEmail() {
        return email;
    }


    public boolean getPrimaryContact() {
        return primaryContact;
    }


    @XmlTransient
    public List<InvoiceDto> getInvoiceList() {
        return invoiceList;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "cz.crmf.dto.Contact[ id=" + id + " ]";
    }
    
}
