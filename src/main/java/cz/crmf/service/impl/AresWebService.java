package cz.crmf.service.impl;

import cz.crmf.model.dto.invoicing.ContactDto;
import cz.crmf.service.iface.CompanyDataWebServiceClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.input.*;

/**
 * Deals with the loading XML data from the ARES Basic Web Access Service.
 *
 * Specs: http://wwwinfo.mfcr.cz/ares/xml_doc/schemas/index.html
 *
 * Example:
 * http://wwwinfo.mfcr.cz/cgi-bin/ares/darv_bas.cgi?ico=27074358&ver=1.0.2
 *
 * @author standa
 */
public class AresWebService implements CompanyDataWebServiceClient {
    
    /**
     * public access endpoint to the basic web service
     * {0} will by replaced by the company registration number
     */
    public static final String ARES_URL = "http://wwwinfo.mfcr.cz/cgi-bin/ares/darv_bas.cgi?ico={0}&ver=1.0.2";

    /**
     * simply load a file from somewhere on the internet using http
     *
     * @param fileUrl
     * @return
     */
    private String loadUrl(String fileUrl) {

        StringBuilder responseBuilder = new StringBuilder();
        try {
            // Create a URLConnection object for a URL
            URL url = new URL(fileUrl);
            URLConnection conn = url.openConnection();
            HttpURLConnection httpConn;

            httpConn = (HttpURLConnection) conn;
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String line;

            while ((line = rd.readLine()) != null) {
                responseBuilder.append(line).append('\n');
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return responseBuilder.toString();
    }

    /**
     * convert a string data into a JDOM Document 
     * @param xmlData
     * @return JDom document
     */
    private Document initXml(String xmlData) {

        SAXBuilder sb = new SAXBuilder();
        Document d = null;
        try {
            d = sb.build(new StringReader(xmlData));
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return d;

    }
    
    /**
     * loads the data from the public ARES database and converts them into
     * an easily usable DTO
     * @param regNo
     * @return ContactDto filled with all data available from ARES register 
     * or null if the record does not exists or data transfer error occured.
     * The data returned are street, number, zip, district, city, region, 
     * country, companyId, vatNo (empty if company has none), company.
     */
    @Override
    public ContactDto getContactDtoByRegNo(String regNo) {
        
        Document d = initXml(loadUrl(MessageFormat.format(ARES_URL, regNo)));
        
        Namespace are = Namespace.getNamespace("are", "http://wwwinfo.mfcr.cz/ares/xml_doc/schemas/ares/ares_answer_basic/v_1.0.2");
        Namespace dtt = Namespace.getNamespace("dtt", "http://wwwinfo.mfcr.cz/ares/xml_doc/schemas/ares/ares_datatypes/v_1.0.2");
        
        if (d.getRootElement().getChild("Odpoved", are) != null &&
                d.getRootElement().getChild("Odpoved", are).getChildText("Pocet_zaznamu", dtt) != null) {
            String pocetZaznamu = d.getRootElement().getChild("Odpoved", are).getChildText("Pocet_zaznamu", dtt);
            
//            System.out.println("pocetZaznamu: "+pocetZaznamu);
            
            if (pocetZaznamu.equals("0")) {
                return null;
            }
        } else {
            System.err.println("ARES Error. No content loaded for regNo: "+regNo);
            return null;
        }
        
        Element root = d.getRootElement().getChild("Odpoved", are).getChild("Vypis_basic", dtt);
        
        // <dtt:ICO zdroj="OR">27074358</dtt:ICO>
        String companyId = root.getChildText("ICO", dtt);
        
        // <dtt:DIC zdroj="DPH">CZ27074358</dtt:DIC>
        String vatNo = root.getChildText("DIC", dtt) != null ? root.getChildText("DIC", dtt) : "";
        
        // <dtt:Obchodni_firma zdroj="OR">Asseco Central Europe, a.s.</dtt:Obchodni_firma>        
        String company = root.getChildText("Obchodni_firma", dtt);       
        
        // <dtt:Nazev_statu>Česká republika</dtt:Nazev_statu>
        String country = root.getChild("Adresa_ARES", dtt).getChildText("Nazev_statu", dtt);
        
        // <dtt:Nazev_okresu>Třebíč</dtt:Nazev_okresu>
        String region = root.getChild("Adresa_ARES", dtt).getChildText("Nazev_okresu", dtt);
        
        //<dtt:Nazev_obce>Praha</dtt:Nazev_obce>
        String city = root.getChild("Adresa_ARES", dtt).getChildText("Nazev_obce", dtt);
        
        //<dtt:Nazev_casti_obce>Michle</dtt:Nazev_casti_obce>
        String district = "";
        if (root.getChild("Adresa_ARES", dtt).getChildText("Nazev_casti_obce", dtt) != null && 
                !root.getChild("Adresa_ARES", dtt).getChildText("Nazev_casti_obce", dtt).equals(city)) {
            district = root.getChild("Adresa_ARES", dtt).getChildText("Nazev_casti_obce", dtt);
        }
        
        //<dtt:Nazev_ulice>Budějovická</dtt:Nazev_ulice>
        String street = root.getChild("Adresa_ARES", dtt).getChildText("Nazev_ulice", dtt);
        
        //<dtt:Cislo_domovni>778</dtt:Cislo_domovni>
        String number = root.getChild("Adresa_ARES", dtt).getChildText("Cislo_domovni", dtt);
        
        //<dtt:Cislo_orientacni>3a</dtt:Cislo_orientacni>
        if (root.getChild("Adresa_ARES", dtt).getChild("Cislo_orientacni", dtt) != null) {
            number += "/"+root.getChild("Adresa_ARES", dtt).getChildText("Cislo_orientacni", dtt);
        }
        
        //<dtt:PSC>14000</dtt:PSC>
        String zip = root.getChild("Adresa_ARES", dtt).getChildText("PSC", dtt);
        
        return new ContactDto(street, number, 
            zip, district, city, region, 
            country, companyId, vatNo, company);  
    }
}
