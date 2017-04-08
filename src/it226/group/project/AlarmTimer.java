package it226.group.project;

import java.util.Timer;
import java.util.Date;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 * http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html
 */
public class AlarmTimer extends Alarm {
    private Date date;
    private Timer timer;
    private int minutes;
    private int seconds;
    
    public AlarmTimer() {
        super();
    }

    public AlarmTimer(Date date, String optionalMessage, int minutes, int seconds) {
        super(date, optionalMessage);
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

    public Date getDate() { return date; }

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
