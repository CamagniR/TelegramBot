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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camagni_riccardo
 */
public class OpenStreetMap {
   

       
    
public String getInfo(String citta)
{
     String url2="https://nominatim.openstreetmap.org/search?q=+"+URLEncoder.encode(citta, StandardCharsets.UTF_8)+"&format=xml&polygon_geojson=1&addressdetails=1";   
     BufferedReader in = null;
     PrintWriter out;
     String line="";
        
        try {
            out = new PrintWriter("xml/Place.xml");

            URL url;
            url = new URL(url2);
            in = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(OpenStreetMap.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
    return line;
}
    

    
    
}
