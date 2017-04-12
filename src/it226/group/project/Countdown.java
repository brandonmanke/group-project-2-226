package it226.group.project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Countdown {

	public Countdown() {
		super();
	}

	Timer timer;
	Calendar calendar;

	ArrayList<Alarm> listOfAlarms = AlarmWriter.getList();
	ArrayList<AlarmTimer> listOfTimers = TimerWriter.getList();

	String[] buttons = {"Dismiss", "Snooze"};
	
	String optionalMessage;
	
	public void runAlarm() {
		timer = new Timer();
		Alarm alarm;

		for (int i = 0; i < listOfAlarms.size(); i++) {

			alarm = listOfAlarms.get(i);
			optionalMessage = alarm.getOptionalMessage();

			calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-"));
			if (alarm.getTime() - calendar.getTimeInMillis() > 0) {

				System.out.println("alarm was set");
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						System.out.println("alarm fired");
						
						int pane = JOptionPane.showOptionDialog(null, optionalMessage, "Alarm!!", JOptionPane.WARNING_MESSAGE, 
								0, null, buttons, buttons[0]);

					}

				}, alarm.getDate());
			} else {
				listOfAlarms.remove(i);
				System.out.println("removed alarm");
			}
		}

	}
	
	public void runTimer() {
		
		AlarmTimer myTimer;
		for (int i = 0; i < listOfTimers.size(); i++){
			
		//find out if timers and alarms have been fired
			//then remove the value from the array that has been fired
			//then set the new array after the removed value equal to the timerWriter/AlarmWriter 
		
			timer = new Timer();
			myTimer = listOfTimers.get(i);
			timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("alarm fired");
				
			}
			
		}, myTimer.getMilliseconds());
	}
	}

}
