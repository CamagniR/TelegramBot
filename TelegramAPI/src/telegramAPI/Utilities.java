/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.SAXException;


/**
 *
 * @author camagni_riccardo
 * https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/getMe uri bot
 * https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/getUpdates?offset=881949579 scarta tutto quello che c'è pruima e aspetta un nuov messaggio
 */
public class Utilities {
    
 //parser e il contrario   
    
    
 long lastID=0;
    
public void sendMessage(String messaggio, long id) throws MalformedURLException, IOException
{
    String url="https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/sendMessage?chat_id="+Long.toString(id)+"&text="+URLEncoder.encode(messaggio, StandardCharsets.UTF_8);
    BufferedReader in = null;
    URL url2;
    url2 = new URL(url);
    in = new BufferedReader(new InputStreamReader(url2.openStream()));
     
}

public int getID() throws MalformedURLException, IOException
{
  
    String url="https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/getUpdates?";
    BufferedReader in = null;
    URL url2;
    url2 = new URL(url);
    in = new BufferedReader(new InputStreamReader(url2.openStream()));
    String line;
    String jsonString="";
            while ((line = in.readLine()) != null) {
                jsonString+=line;
            }
            in.close();
     
    JSONObject obj = new JSONObject(jsonString);  
    JSONArray arr = obj.getJSONArray("result");        
    int idUtente=0;
  
    for (int i = 0; i < arr.length(); i++)
    {
      idUtente=arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getInt("id");
    }
    
    return idUtente;
}

//ritorno un lista di tutti i messaggi che ho ricevuto
public List<ParametriUpdate> getUpdates() throws MalformedURLException, IOException
{
    ParametriUpdate parametri= new ParametriUpdate();
    String url="";
    
    if(lastID==0)
    {
     url="https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/getUpdates?";
    }else{
     url="https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/getUpdates?offset="+(lastID+1);
    }
    
    BufferedReader in = null;
    URL url2;
    url2 = new URL(url);
    in = new BufferedReader(new InputStreamReader(url2.openStream()));
    String line;
    String jsonString="";
            while ((line = in.readLine()) != null) {
                jsonString+=line;
            }
            in.close();
     
    JSONObject obj = new JSONObject(jsonString);  
    JSONArray arr = obj.getJSONArray("result");        
    int idUtente=0;
    
  List<ParametriUpdate> lista=new  ArrayList<ParametriUpdate>();
  
    for (int i = 0; i < arr.length(); i++)
    {
     // idUtente=arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getInt("id");
      parametri.setUpdate_id(arr.getJSONObject(i).getLong("update_id"));
      parametri.setMessageID(arr.getJSONObject(i).getJSONObject("message").getInt("message_id"));
      parametri.setText(arr.getJSONObject(i).getJSONObject("message").getString("text"));
      parametri.setID(arr.getJSONObject(i).getJSONObject("message").getJSONObject("from").getInt("id"));
      
      if(parametri.getUpdate_id()>lastID)
      {
          lastID=parametri.getUpdate_id();
      }
      lista.add(parametri); 
      
     
    }
    
    return lista;
}

public String getText() throws MalformedURLException, IOException
{
  
    String url="https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/getUpdates?";
    BufferedReader in = null;
    URL url2;
    url2 = new URL(url);
    in = new BufferedReader(new InputStreamReader(url2.openStream()));
    String line;
    String jsonString="";
            while ((line = in.readLine()) != null) {
                jsonString+=line;
            }
            in.close();
     
    JSONObject obj = new JSONObject(jsonString);  
    JSONArray arr = obj.getJSONArray("result");        
    int message_id=0;
    int idUtente=0;
    String text="";
      
    
    for (int i = 0; i < arr.length(); i++)
    {
        text=arr.getJSONObject(i).getJSONObject("message").getString("text");
    }
      
    return text;
}
public int getMessageID() throws MalformedURLException, IOException
{
  
    String url="https://api.telegram.org/bot5122281672:AAHK1whl7VGxCdHszxOYBR8UwtD07SFadvg/getUpdates?";
    BufferedReader in = null;
    URL url2;
    url2 = new URL(url);
    in = new BufferedReader(new InputStreamReader(url2.openStream()));
    String line;
    String jsonString="";
            while ((line = in.readLine()) != null) {
                jsonString+=line;
            }
            in.close();
     
    JSONObject obj = new JSONObject(jsonString);  
    JSONArray arr = obj.getJSONArray("result");        
    int message_id=0;
      
    for (int i = 0; i < arr.length(); i++)
    {
        message_id = arr.getJSONObject(i).getJSONObject("message").getInt("message_id") ;
    }
    return message_id;
}
    
}
