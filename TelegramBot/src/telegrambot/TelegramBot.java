/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.IOException;
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
        
        Utilities oggetto = new Utilities();
        String testo=oggetto.getText();
        int idDestinatario=oggetto.getID();
        int idMessaggio=oggetto.getMessageID();
        

    
        if (testo.contains("/citta")==true ) {
            //oggetto.sendMessage("inserisci la città da cercare", idDestinatario);
            testo  = testo.replace("/citta", ""); 
            testo=testo.trim();
            OpenStreetMap tmp=new OpenStreetMap();
            tmp.getInfo(testo);
           
        }
     
        
    
        

        
    }
    
}
