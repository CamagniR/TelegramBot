/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import telegramAPI.Utilities;

/**
 *
 * @author camagni_riccardo
 */
public class OpenStreetMap {
    
private String file="dati.csv";
   
public String toCSV(long idDestinatario,String lati, String longi)
     {
         String tmp= "";
         tmp= Long.toString(idDestinatario)+";"+lati+";"+longi+"\n";
         return tmp;
     }
     
    public void salvaFile(String testo) throws IOException
    {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(testo);
        bw.newLine();
        bw.close();
       
    }
       
   
public void rispondi(String citta,long idDestinatario)
{
        BufferedReader in = null;
        PrintWriter out;
        
        Utilities oggetto=new Utilities();
        
        try {
            out = new PrintWriter("xml/Place.xml");

            URL url;
           
            String url2="https://nominatim.openstreetmap.org/search?q=+"+URLEncoder.encode(citta, StandardCharsets.UTF_8)+"&format=xml&polygon_geojson=1&addressdetails=1";  
            url= new URL (url2);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Pubblicita.class.getName()).log(Level.SEVERE, null, ex);
        }

        MyXMLOperations xml = new MyXMLOperations();
        // String xsd = "xml/grammatica.xsd";
        String xmlFile = "xml/Place.xml";
        String invio="";
        try {
            List<Place> dati = new ArrayList<>();
            dati = xml.parseDocument(xmlFile);
            System.out.println(dati.size());
            System.out.println("---------------------------------------------------");
            
               Place info = dati.get(0);
                invio="Luogo "+info.getDisplay_name()+"\n"+"Latitudine "+ info.getLatitudine()+"\n"+"Longitudine "+info.getLongitudine()+"\n";
                
                salvaFile(toCSV(idDestinatario,info.getLatitudine() , info.getLongitudine()));
                
                oggetto.sendMessage(invio, idDestinatario);
                
                
                
                /*
            for (int i = 0; i < dati.size(); i++) {
             
                   Place info = dati.get(i);
                
                    invio="Luogo "+info.getDisplay_name()+"\n"+"Latitudine "+ info.getLatitudine()+"\n"+"Longitudine "+info.getLongitudine()+"\n";
                oggetto.sendMessage(invio, idDestinatario);
            
                
                
                
                System.out.println("nome "+info.getDisplay_name());
                System.out.println("Latitudine "+info.getLatitudine());
                System.out.println("Longitudine "+info.getLongitudine());
                System.out.println("amenity "+info.getAmenity());
                System.out.println("building "+ info.getBuilding());
                System.out.println("house_number "+ info.getHouse_number() );
                System.out.println("road "+ info.getRoad());
                System.out.println("village "+info.getVillage());
                System.out.println("town "+ info.getTown());
                System.out.println("county "+ info.getCounty());
                System.out.println("state "+ info.getState());
                System.out.println("postcode "+ info.getPostcode());
                System.out.println("country "+ info.getCountry());
                System.out.println("country_code "+info.getCountry_code());
                
                System.out.println("---------------------------------------------------");
            }
            */
            System.out.println("---------------------------------------------------");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println(exception);
        }
      

}
  

public String getLatitudine(String cittaRicercata) {

     BufferedReader in = null;
        PrintWriter out;
        
        Utilities oggetto=new Utilities();
        
        try {
            out = new PrintWriter("xml/Place.xml");

            URL url;
           
            String url2="https://nominatim.openstreetmap.org/search?q=+"+URLEncoder.encode(cittaRicercata, StandardCharsets.UTF_8)+"&format=xml&polygon_geojson=1&addressdetails=1";  
            url= new URL (url2);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Pubblicita.class.getName()).log(Level.SEVERE, null, ex);
        }

        MyXMLOperations xml = new MyXMLOperations();
        // String xsd = "xml/grammatica.xsd";
        String xmlFile = "xml/Place.xml";
        String latitudine="";
        try {
            List<Place> dati = new ArrayList<>();
            dati = xml.parseDocument(xmlFile);
               Place info = dati.get(0);
               latitudine=info.getLatitudine();
    
         System.out.println("---------------------------------------------------");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println(exception);
        }

        return latitudine;
}
public String getLongitudine(String cittaRicercata) {

     BufferedReader in = null;
        PrintWriter out;
        
        Utilities oggetto=new Utilities();
        
        try {
            out = new PrintWriter("xml/Place.xml");

            URL url;
           
            String url2="https://nominatim.openstreetmap.org/search?q=+"+URLEncoder.encode(cittaRicercata, StandardCharsets.UTF_8)+"&format=xml&polygon_geojson=1&addressdetails=1";  
            url= new URL (url2);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Pubblicita.class.getName()).log(Level.SEVERE, null, ex);
        }

        MyXMLOperations xml = new MyXMLOperations();
        // String xsd = "xml/grammatica.xsd";
        String xmlFile = "xml/Place.xml";
        String longitudine="";
        try {
            List<Place> dati = new ArrayList<>();
            dati = xml.parseDocument(xmlFile);
               Place info = dati.get(0);
               longitudine=info.getLongitudine();
    
         System.out.println("---------------------------------------------------");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println(exception);
        }

        return longitudine;
}



}
