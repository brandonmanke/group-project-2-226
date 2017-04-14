package it226.group.project;

import java.util.Date;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 * http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html
 */
public class AlarmTimer extends Alarm {
    private long milliseconds;
    
    public AlarmTimer() {
        super();
    }

    public AlarmTimer(Date date, int hours, int minutes, int seconds, String optionalMessage, boolean isFired) {
        super(date, optionalMessage, isFired);
        milliseconds = (seconds * 1000) + (minutes * 60000) + (hours * 3600000);
        date = new Date(milliseconds);
        this.setDate(date);
    }

    public AlarmTimer writeToJson() {
        TimerWriter.addToJson(this);
        return this;
    }

    private Date convertTimerToDate() {
        return this.getDate();
    }

    // Getters

    public long getMilliseconds() { return milliseconds; }

    // Setters

    public void setMilliseconds(long milliseconds) { this.milliseconds = milliseconds; }

}
