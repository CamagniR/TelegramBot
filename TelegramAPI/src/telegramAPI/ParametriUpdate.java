/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramAPI;

/**
 *
 * @author camagni_riccardo
 */
public class ParametriUpdate {
 
    long ID;
    int messageID;
    long update_id;
    String text;

    public ParametriUpdate() {
        ID=0;
        messageID=0;
        text="";
        update_id=0;
    }
    
    public ParametriUpdate(long update_id,long ID, int messageID, String text) {
        this.update_id=update_id;
        this.ID = ID;
        this.messageID = messageID;
        this.text = text;
    }

    public long getUpdate_id() {
        return update_id;
    }

    public long getID() {
        return ID;
    }

    public int getMessageID() {
        return messageID;
    }

    public String getText() {
        return text;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setUpdate_id(long update_id) {
        this.update_id = update_id;
    }
    
    
    
    
    
    
    
    
    
    
}
