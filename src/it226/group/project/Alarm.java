package it226.group.project;

import java.util.Date;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public class Alarm implements IClock {
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
        JsonWriter.addToJson(this);
        return this;
    }

    public Alarm readJson() {
        return null;
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

    /*

        public Clock writeToJson() {
        JsonWriter.initializeWriter(ReadingFromJson.readFromJson());
        JsonWriter.addToJson(this);
        return this;
        }

     */

}
