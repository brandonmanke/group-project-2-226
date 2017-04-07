package it226.group.project;

import com.google.gson.*;
import java.util.Timer;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public class myTimer extends Clock {
    private Timer timer;
    private String optionalMessage;
    private int minutes;
    private int seconds;

    public myTimer(Timer timer, String optionalMessage, int minutes, int seconds) {
        super();
        this.timer = timer;
        this.optionalMessage = optionalMessage;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Clock writeToJson() {
        return null;
    }

    public Clock readFromJson() {
        return null;
    }

    // Getters

    public int getMinutes() { return minutes; }

    public int getSeconds() { return seconds; }

    public String getOptionalMessage() { return optionalMessage; }

    public Timer getTimer() { return timer; }

    // Setters

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setOptionalMessage(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

}
