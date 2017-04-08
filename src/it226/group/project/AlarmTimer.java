package it226.group.project;

//import com.google.gson.*;
import java.util.Timer;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 * http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html
 */
public class AlarmTimer extends Clock {
    private Timer timer;
    private int minutes;
    private int seconds;
    
    public AlarmTimer() {
        super();
    }

    public AlarmTimer(String optionalMessage, int minutes, int seconds) {
        super(optionalMessage);
        timer = new Timer();
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

    public Timer getTimer() { return timer; }

    // Setters

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

}
