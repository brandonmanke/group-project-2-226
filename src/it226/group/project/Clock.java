package it226.group.project;

import java.util.Date;

/**
 * Base class of both AlarmTimer & Alarm
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
// MAYBE MAKE THIS AN INTERFACE??
public abstract class Clock {
    private Date date;
    private String optionalMessage;

    public Clock() {
        super();
    }

    public Clock(Date date, String optionalMessage) {
        this.date = date;
        this.optionalMessage = optionalMessage;
    }

    public String getOptionalMessage() { return optionalMessage; }

    public void setOptionalMessage(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

    public Clock writeToJson() {
        JsonWriter.initializeWriter(ReadingFromJson.readFromJson());
        JsonWriter.addToJson(this);
        return this;
    }

    // BROKEN tbh fix this, Clock only supports getOptionalMessage()
    // therefore when we read from the json file and put everything into a clock arraylist
    // we can only get the optional message, which is completely useless actually gg
    // if clock has a date object then it is actually the same thing as alarm so maybe
    // we just need alarm and alarm timer and no clock class, maybe make clock a interface
    public Clock readFromJson() {
        ReadingFromJson.readFromJson();
        return this;
    }

    public abstract Date getDate();

}
