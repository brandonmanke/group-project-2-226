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

    public Alarm() {
        super();
    }

    public Alarm(Date date, String optionalMessage) {
        this.date = date;
        this.optionalMessage = optionalMessage;
    }

    public Alarm writeToJson() {
        AlarmWriter.addToJson(this);
        return this;
    }

    // Getters

    public Date getDate() { return date; }

    public long getTime() { return date.getTime(); }

    public String getOptionalMessage() { return optionalMessage; }

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

}
