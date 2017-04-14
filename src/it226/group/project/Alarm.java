package it226.group.project;

import java.util.Date;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public class Alarm {
    private Date date;
    private String optionalMessage;
    private boolean isFired;
    private int numSnooze = 0;

    public Alarm() {
        super();
    }
    

    public Alarm(Date date, String optionalMessage, boolean isFired) {
        this.date = date;
        this.optionalMessage = optionalMessage;
        this.isFired = isFired;
        
    }

    public Alarm writeToJson() {
        AlarmWriter.addToJson(this);
        return this;
    }
    
    // Getters

    public Date getDate() { return date; }

    public long getTime() { return date.getTime(); }

    public String getOptionalMessage() { return optionalMessage; }
    
    public boolean getIsFired(){return isFired; }
    
    public int getNumSnooze(){ return numSnooze; }

    // Setters

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(long time){
    	this.date.setTime(time);
    }

    public void setOptionalMessage(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }
    
    public void setIsFired(boolean isFired){
    	this.isFired = isFired;
    }
    
    public void setNumSnooze(int num){
    	this.numSnooze = num;
    }

}
