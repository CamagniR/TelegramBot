/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Riccardo
 */
public class MyXMLOperations {
    
    
    private Document document;

    public Document getDocument() {
        return document;
    }
    
    public void validate(String XMLdocument, String XSDschema) throws SAXException, IOException {
        // creazione di uno schema XSD a partire dal file
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        File schemaFile = new File(XSDschema);
        Schema schema = factory.newSchema(schemaFile);
        // creazione di un validatore rispetto allo schema XSD
        Validator validator = schema.newValidator();
        // validazione del documento XML
        Source source = new StreamSource(XMLdocument);
        validator.validate(source);
    }
    
     public List parseDocument(String filename)
            throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Element root, element;
        NodeList nodelist;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        
        document = builder.parse(filename);
        root = document.getDocumentElement();
        List<Place> dati = new ArrayList();
        Place dato;
        nodelist = root.getElementsByTagName("place");
        System.out.println(nodelist.getLength());
        if (nodelist != null && nodelist.getLength() > 0) {
            int numNode = nodelist.getLength();
            for (int i = 0; i < numNode; i++) {
                element = (Element) nodelist.item(i);
                dato = getInfo(element);
                dati.add(dato);
            }
        }
        return dati;
    }
    
     private Place getInfo(Element element) {
        
        Place place = null;
        NodeList nodelist;
        place = new Place();
        
        String lati = element.getAttribute("lat");
        if ((!"".equals(lati))) {       
          place.setLatitudine(lati);
        }
        String longi = element.getAttribute("lon");
        if ((!"".equals(longi))) {            
          place.setLongitudine(longi);
        }
        String str = element.getAttribute("display_name");
        if ((!"".equals(str))) {   
        
          place.setDisplay_name(str);
        }
        nodelist=element.getElementsByTagName("amenity");
         if (nodelist.getLength()>0 ) {
             String lamenety= nodelist.item(0).getFirstChild().getNodeValue();
             place.setAmenity(lamenety);
        }
        
         nodelist=element.getElementsByTagName("road");
         if (nodelist.getLength()>0 ) {
             String road= nodelist.item(0).getFirstChild().getNodeValue();
             place.setRoad(road);
         }
         
         nodelist=element.getElementsByTagName("town");
         if (nodelist.getLength()>0 ) {
             String town= nodelist.item(0).getFirstChild().getNodeValue();
             place.setTown(town);
             
         }
         nodelist=element.getElementsByTagName("county");
         if (nodelist.getLength()>0 ) {
             String county= nodelist.item(0).getFirstChild().getNodeValue();
             place.setCounty(county);
         }
         
         nodelist=element.getElementsByTagName("state");
         if (nodelist.getLength()>0 ) {
             String state= nodelist.item(0).getFirstChild().getNodeValue();
             place.setState(state);
         }
         
         nodelist=element.getElementsByTagName("postcode");
         if (nodelist.getLength()>0 ) {
             String postcode= nodelist.item(0).getFirstChild().getNodeValue();
             place.setPostcode(postcode);
         }
         
         nodelist=element.getElementsByTagName("country");
         if (nodelist.getLength()>0 ) {
             String country= nodelist.item(0).getFirstChild().getNodeValue();
             place.setCountry(country);
         }
         
         nodelist=element.getElementsByTagName("country_code");
         if (nodelist.getLength()>0 ) {
             String country_code= nodelist.item(0).getFirstChild().getNodeValue();
             place.setCountry_code(country_code);
         }
         
         nodelist=element.getElementsByTagName("building");
         if (nodelist.getLength()>0 ) {
             String building= nodelist.item(0).getFirstChild().getNodeValue();
             place.setBuilding(building);
         }
         
         nodelist=element.getElementsByTagName("house_number");
         if (nodelist.getLength()>0 ) {
             String house_number= nodelist.item(0).getFirstChild().getNodeValue();
             place.setHouse_number(house_number);
         }
         
         nodelist=element.getElementsByTagName("village");
         if (nodelist.getLength()>0 ) {
             String village= nodelist.item(0).getFirstChild().getNodeValue();
             place.setVillage(village);
         }
         
         
         
       
        
        return place;
    }
    
    
    
    
    
    
    
    
}

