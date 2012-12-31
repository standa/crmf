/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crmf.model.service.impl;

import cz.crmf.model.dto.invoicing.ContactDto;
import cz.crmf.model.dto.invoicing.CustomerDto;
import cz.crmf.model.dto.invoicing.OrderItemDto;
import cz.crmf.model.dto.invoicing.RoleDto;
import cz.crmf.model.service.AbstractDataAccessServiceTest;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.*;

/**
 *
 * @author standa
 */
public class InvoicingServiceImplTest extends AbstractDataAccessServiceTest {
    
    public InvoicingServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createRole method, of class InvoicingServiceImpl.
     */
    @Test
    public void testCreateRole() {
        System.out.println("createRole");
        String roleName = "";
        String description = "";
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        Integer expResult = null;
        Integer result = instance.createRole(roleName, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllRoles method, of class InvoicingServiceImpl.
     */
    @Test
    public void testGetAllRoles() {
        System.out.println("getAllRoles");
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        List expResult = null;
        List result = instance.getAllRoles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleById method, of class InvoicingServiceImpl.
     */
    @Test
    public void testGetRoleById() {
        System.out.println("getRoleById");
        Integer roleId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        RoleDto expResult = null;
        RoleDto result = instance.getRoleById(roleId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRole method, of class InvoicingServiceImpl.
     */
    @Test
    public void testDeleteRole() {
        System.out.println("deleteRole");
        Integer roleId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        instance.deleteRole(roleId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createContact method, of class InvoicingServiceImpl.
     */
    @Test
    public void testCreateContact() {
        System.out.println("createContact");
        String name = "";
        String surname = "";
        String street = "";
        String number = "";
        String zip = "";
        String district = "";
        String city = "";
        String region = "";
        String country = "";
        String companyId = "";
        String vatNo = "";
        String company = "";
        String bankAccount = "";
        String bank = "";
        String phone = "";
        String email = "";
        Boolean primaryContact = null;
        Integer customerId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        ContactDto expResult = null;
        ContactDto result = instance.createContact(name, surname, street, number, zip, district, city, region, country, companyId, vatNo, company, bankAccount, bank, phone, email, primaryContact, customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactByID method, of class InvoicingServiceImpl.
     */
    @Test
    public void testGetContactByID() {
        System.out.println("getContactByID");
        Integer contactId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        ContactDto expResult = null;
        ContactDto result = instance.getContactByID(contactId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteContact method, of class InvoicingServiceImpl.
     */
    @Test
    public void testDeleteContact() {
        System.out.println("deleteContact");
        Integer contactId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        instance.deleteContact(contactId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCustomer method, of class InvoicingServiceImpl.
     */
    @Test
    public void testCreateCustomer() {
        System.out.println("createCustomer");
        String username = "";
        String password = "";
        String email = "";
        Integer roleId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        Integer expResult = null;
        Integer result = instance.createCustomer(username, password, email, roleId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerById method, of class InvoicingServiceImpl.
     */
    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        Integer customerId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        CustomerDto expResult = null;
        CustomerDto result = instance.getCustomerById(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class InvoicingServiceImpl.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        Integer customerId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        instance.deleteCustomer(customerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createInvoice method, of class InvoicingServiceImpl.
     */
    @Test
    public void testCreateInvoice() {
        System.out.println("createInvoice");
        float total = 0.0F;
        float bookingAmount = 0.0F;
        Date issueDate = null;
        Date dueDate = null;
        Integer customerId = null;
        Integer billingContact = null;
        Integer deliveryContact = null;
        String note = "";
        byte[] invoicePdf = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        Integer expResult = null;
        Integer result = instance.createInvoice(total, bookingAmount, issueDate, dueDate, customerId, billingContact, deliveryContact, note, invoicePdf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoicesByCustomerId method, of class InvoicingServiceImpl.
     */
    @Test
    public void testGetInvoicesByCustomerId() {
        System.out.println("getInvoicesByCustomerId");
        Integer customerId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        List expResult = null;
        List result = instance.getInvoicesByCustomerId(customerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteInvoice method, of class InvoicingServiceImpl.
     */
    @Test
    public void testDeleteInvoice() {
        System.out.println("deleteInvoice");
        Integer invoiceId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        instance.deleteInvoice(invoiceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrderItem method, of class InvoicingServiceImpl.
     */
    @Test
    public void testCreateOrderItem() {
        System.out.println("createOrderItem");
        Integer invoiceId = null;
        String productName = "";
        String description = "";
        Integer quantity = null;
        Float unitPrice = null;
        Float vatRate = null;
        String currency = "";
        Float subtotal = null;
        Date validFrom = null;
        Date validUntil = null;
        Integer reminderDays = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        OrderItemDto expResult = null;
        OrderItemDto result = instance.createOrderItem(invoiceId, productName, description, quantity, unitPrice, vatRate, currency, subtotal, validFrom, validUntil, reminderDays);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOrderItem method, of class InvoicingServiceImpl.
     */
    @Test
    public void testDeleteOrderItem() {
        System.out.println("deleteOrderItem");
        Integer orderItemId = null;
        InvoicingServiceImpl instance = new InvoicingServiceImpl();
        instance.deleteOrderItem(orderItemId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
