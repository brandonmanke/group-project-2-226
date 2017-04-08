package it226.group.project;

import com.google.gson.*;

import java.util.Date;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public class Alarm extends Clock {
    private Date date;

    public Alarm() {
        super();
    }

    public Alarm(Date date, String optionalMessage) {
        super(optionalMessage);
        this.date = date;
    }

    public Clock readFromJson() {
        return null;
    }

    // Getters

    public Date getDate() { return date; }

    // Setters

    public void setDate(Date date) {
        this.date = date;
    }

}
