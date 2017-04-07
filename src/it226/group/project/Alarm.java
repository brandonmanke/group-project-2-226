package it226.group.project;

import com.google.gson.*;
import java.util.Date;
import java.util.Timer;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public class Alarm extends Clock {
    private Date date;
    private Timer timer;
    private String optionalMessage;

    public Alarm(Date date, Timer timer, String optionalMessage) {
        super();
        this.date = date;
        this.timer = timer;
        this.optionalMessage = optionalMessage;
    }

    public Clock writeToJson() {
        return null;
    }

    public Clock readFromJson() {
        return null;
    }

    // Getters

    public Date getDate() { return date; }

    public Timer getTimer() { return timer; }

    public String getOptionalMessage() { return optionalMessage; }

    // Setters

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void setOptionalMessage(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

}
