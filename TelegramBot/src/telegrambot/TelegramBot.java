/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.BufferedReader;
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
public class TelegramBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       
        while(true)
        {
           ThreadAscolto th1= new ThreadAscolto();
           th1.start();
            try {
                th1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(TelegramBot.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                th1.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TelegramBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               
          
           
           
           
       /*    
        BufferedReader in = null;
        PrintWriter out;
        
        try {
            out = new PrintWriter("xml/Place.xml");

            URL url;
           
            String url2="https://nominatim.openstreetmap.org/search?q=+"+URLEncoder.encode(testo, StandardCharsets.UTF_8)+"&format=xml&polygon_geojson=1&addressdetails=1";  
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
            Logger.getLogger(TelegramBot.class.getName()).log(Level.SEVERE, null, ex);
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
            for (int i = 0; i < dati.size(); i++) {
                Place info = dati.get(i);
               
                
                
                invio="Luogo "+info.getDisplay_name()+"\n"+"Latitudine "+ info.getLatitudine()+"\n"+"Longitudine "+info.getLongitudine()+"\n";
                oggetto.sendMessage(invio, idDestinatario);
                
                
                /*
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
                */
       /*
                System.out.println("---------------------------------------------------");
            }
            System.out.println("---------------------------------------------------");
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println(exception);
        }
               */
        }
     
   
}
        
