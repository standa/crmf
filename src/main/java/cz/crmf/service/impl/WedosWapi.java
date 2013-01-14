package cz.crmf.service.impl;

import cz.crmf.provider.HashProvider;
import cz.crmf.provider.SHA1Provider;
import cz.crmf.service.iface.DomainDataWebServiceClient;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Service;

/**
 * This class is a reference implementation of the web service client
 * for checking domain existence, registering new domains, checking domain
 * owners, etc.
 * 
 * inspired by: http://kb.wedos.com/wapi/komunikace.html
 * 
 * @author standa
 */
@Service("domainDataService")
public class WedosWapi implements DomainDataWebServiceClient {
    
    /**
     * string used for authentication to wedos
     */
    private String auth;
    
    /**
     * wedos user name
     */
    private String wedosUser;

    /**
     * wedos api generate using the client portal
     */
    private String wapiPassword;
    
    /**
     * the testing flag... no changes will be comitted
     */
    private static final boolean TEST = true;
    
    
    private static final String ENDPOINT_URL = "https://api.wedos.com/wapi/xml";

    /**
     * generate the initial auth value and check if we can login
     * 
     * @param wedosUser
     * @param wapiPassword 
     */
    public WedosWapi(String wedosUser, String wapiPassword) {        
        
        this.wedosUser = wedosUser;
        this.wapiPassword = wapiPassword;
        
        computeAuth();        
        System.out.println("WEDOS auth: "+auth);
        
    }
    
    private void computeAuth() {
        DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        HashProvider hash = new SHA1Provider();
        
        System.out.println("AUTH: "+wedosUser+"+"+wapiPassword+"+"+dateFormat.format(date));
        
        auth = hash.computeHash(wedosUser+hash.computeHash(wapiPassword)+dateFormat.format(date));        
    }
    
    /**
     * builds the request XML
     * <code>
     * 
     * <request>
     *  <user>tester</user>
     *  <auth>202b62bc4646281f97d225db1249840c8452dd8f</auth>
     *  <command>domain-create</command>
     * <clTRID>a44B</clTRID>
     *  <data>
     *   <name>example.cz</name>
     *   <period>1</period>
     *   <dns></dns>
     *   <owner_c>CONTACT</owner_c>
     * <admin_c>CONTACT</admin_c>
     *  </data>
     *  <test>1</test>
     * </request>
     * 
     * </code>
     * @param command is the command to be sent
     * @param data if null no data is sent, otherwise sent addional user <data/>
     * @return root element of the response document
     */
    public Element request(String command, Element data) {
        
        computeAuth();
        
        Element request = new Element("request");
        
        request.addContent(new Element("user").setText(wedosUser));
        request.addContent(new Element("auth").setText(auth));
        request.addContent(new Element("command").setText(command));
        request.addContent(new Element("clTRID").setText(String.valueOf(System.currentTimeMillis())));
        if (data != null) {
            request.addContent(data);            
        }
        
        if (TEST) {
            request.addContent(new Element("test").setText("1"));
        }
        
        Document document = new Document(request);
        
        return postXml(document).getRootElement();
        
    }
    
    private Document postXml(Document xml) {
        
        printElement(xml.getRootElement());
        
        try {
            // Create a URLConnection object for a URL
            URL url = new URL(ENDPOINT_URL);
            URLConnection conn = url.openConnection();            
            HttpURLConnection httpConn;
            
            httpConn = (HttpURLConnection) conn;
                        
            httpConn.setUseCaches(false);
            httpConn.setDoOutput(true);
            httpConn.setRequestMethod("POST");
            
            OutputStream os = httpConn.getOutputStream();            
            BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(os));
            
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getCompactFormat());
            xmlOutput.output(xml, osw);
            
            // osw.write(data); // in case of additional string data being sent
            
            osw.flush();
            osw.close();       
            
            if (httpConn.getResponseCode() != 200) {
                System.out.println("ERROR: "+httpConn.getResponseCode()+" "+httpConn.getResponseMessage());
                return null;
            }

            SAXBuilder saxb = new SAXBuilder();            
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

            return saxb.build(rd);            
            
        } catch (Exception e) {
            System.out.println("WedosWapi.postXml() ERROR: "+e.getMessage());
            return null;
        }        
        
    }
    
    /**
     * print the element and its children to the std out.
     * Used for debug purposes. If TEST is false, then nothing will happen.
     * @param el element to print
     */
    private void printElement(Element el) {
        
        if (!TEST) {
//            return;
        }
        
        XMLOutputter xmlo = new XMLOutputter(Format.getPrettyFormat());
        try {
            xmlo.output(el, System.out);
        } catch (IOException ex) {
            Logger.getLogger(WedosWapi.class.getName()).log(Level.SEVERE, null, ex);
        }  
        System.out.println();
    }
    
    /**
     * Check if the domain of the given name (ie. domain.com) exists.
     * Please note that some additional regulations may apply. Like the Czech
     * domains cannot be shorter than 3 letters.
     * @param domain
     * @return true if the domain is free to register, false if it cannot be
     * registered
     */
    @Override
    public boolean checkDomain(String domain) {
        
        Element data = new Element("data").addContent(new Element("name").setText(domain));
        Element response = request("domain-check", data);
        
        printElement(response);
        
        String code = response.getChildText("code");
        
        if (code.equals("1000")) {
            // domain is free
            return true;
        } else if (code.equals("3201")) {
            // domain is already registered
            return false;
        } else { // other error
            System.out.println("ERROR in WedosWapi.domainExists()");
            return false;
        }
    }
    
}
