/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegramAPI.ParametriUpdate;
import telegramAPI.Utilities;

/**
 *
 * @author camagni_riccardo
 */
public class ThreadAscolto extends Thread {

    public int lastId;
    static Utilities oggetto = new Utilities();
    /*
    ThreadAscolto() {
        lastId = 0;
    }*/
    ThreadAscolto() {
        
    }
    
    ThreadAscolto(int id) {
        lastId = id;
    }

    @Override
    public void run() {

        try {
            List<ParametriUpdate> listaMessaggi=oggetto.getUpdates();
                   
            int lastID=0;
            for(int i=0;i<listaMessaggi.size();i++)
            {
                String testo = listaMessaggi.get(i).getText();
                long idDestinatario = listaMessaggi.get(i).getID();
                int idMessaggio = listaMessaggi.get(i).getMessageID();  
                 if (testo.contains("/citta") == true) {
                    //oggetto.sendMessage("inserisci la città da cercare", idDestinatario);
                    testo = testo.replace("/citta", "");
                    testo = testo.trim();
                    OpenStreetMap tmp = new OpenStreetMap();
                    tmp.rispondi(testo, idDestinatario);
                }
            }
            
            /*
            String testo = oggetto.getText();
            int idDestinatario = oggetto.getID();
            int idMessaggio = oggetto.getMessageID();          
            if (lastId != idMessaggio) {

                if (testo.contains("/citta") == true) {
                    //oggetto.sendMessage("inserisci la città da cercare", idDestinatario);
                    testo = testo.replace("/citta", "");
                    testo = testo.trim();
                    OpenStreetMap tmp = new OpenStreetMap();
                    tmp.rispondi(testo, idDestinatario);
                    TelegramBot.lastId = idMessaggio;
                }
            }
*/
        } catch (IOException ex) {
            Logger.getLogger(ThreadAscolto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
