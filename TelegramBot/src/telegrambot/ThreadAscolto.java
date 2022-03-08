/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegramAPI.Utilities;

/**
 *
 * @author camagni_riccardo
 */
public class ThreadAscolto extends Thread{

    @Override
    public void run() {

        try {
            Utilities oggetto = new Utilities();
            String testo=oggetto.getText();
            int idDestinatario=oggetto.getID();
            int idMessaggio=oggetto.getMessageID();
            
            
            
            if (testo.contains("/citta")==true ) {
                //oggetto.sendMessage("inserisci la città da cercare", idDestinatario);
                testo  = testo.replace("/citta", "");
                testo=testo.trim();
                OpenStreetMap tmp=new OpenStreetMap();
                tmp.rispondi(testo,idDestinatario);
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadAscolto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    
    
         
}
