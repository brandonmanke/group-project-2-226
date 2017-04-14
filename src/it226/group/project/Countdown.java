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
	Timer snooze;
	Calendar calendar;
	
	String optionalMessage;
	
	boolean isFired;
	
	int result;
	
	int numSnooze = 0;

	ArrayList<Alarm> listOfAlarms = AlarmWriter.getList();
	ArrayList<AlarmTimer> listOfTimers = TimerWriter.getList();
	
	Object[] options = {"Snooze", "Dismiss"};
	Object[] timerOptions = {"Dismiss"};
	
	AlarmTimer myTimer;
	
	
	public void runAlarm() {
		
		timer = new Timer();
		
		
		for (int i = 0; i < listOfAlarms.size(); i++) {
			
			final Alarm alarm = listOfAlarms.get(i);
			
			isFired = alarm.getIsFired();
			calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-"));
			
			if(isFired == false){
				alarm.setIsFired(true);
				System.out.println("alarm was set");
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						System.out.println("alarm fired");
							
						optionalMessage = alarm.getOptionalMessage();	
						result = JOptionPane.showOptionDialog(null, optionalMessage, "Alarm!!", JOptionPane.YES_NO_OPTION, 
								JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						
						if (result == JOptionPane.YES_OPTION){
							snooze(alarm);
						}
						else if (result == JOptionPane.NO_OPTION){
							// Logic to delete from file
							// TODO run alarm
							// alarm obj
							// run alarm or timer, once it goes off
							// exit app open json, alarm should be gone
							deleteAlarms(alarm);
							System.out.println("after delete in snooze");
						}

					}

					}, alarm.getDate());		
				
			}
			
		}

	}
	
	public void runTimer() {
		
		timer = new Timer();
		
		for (int i = 0; i < listOfTimers.size(); i++) {
			
			myTimer = listOfTimers.get(i);
			isFired = myTimer.getIsFired();
			
			if (isFired == false) {
				
				myTimer.setIsFired(true);
				System.out.println("timer set");
				
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						System.out.println("timer fired");
						optionalMessage = myTimer.getOptionalMessage();

						result = JOptionPane.showOptionDialog(null, optionalMessage, "Timer!!", JOptionPane.CANCEL_OPTION, 
								JOptionPane.QUESTION_MESSAGE, null, timerOptions, timerOptions);
						
							if (result == JOptionPane.CANCEL_OPTION){
							//Logic to delete from file
							// TODO run timer
							// myTimer obj
							
							deleteAlarms(myTimer);
							myTimer.setIsFired(true);
						}
						
					}
					
				}, myTimer.getMilliseconds());
				
			}
			
		}
	}

	/**
	 * Need to check if timer or alarm in NO_OPTION
	 */
	public void snooze(Alarm obj) {

		//final AlarmTimer tempTimer = (AlarmTimer) obj;
		final Alarm tempAlarm = obj;

		System.out.println("snooze fired");
		snooze = new Timer();
		tempAlarm.setNumSnooze(++numSnooze);
		snooze.schedule(new TimerTask(){
		
		
			@Override
			public void run(){
				
				int snoozeRes = JOptionPane.showOptionDialog(null, "Snooze Alarm", "Snooze Count: " + tempAlarm.getNumSnooze(), JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				if(snoozeRes == JOptionPane.YES_OPTION){
						snooze(tempAlarm);

				}
				else if(snoozeRes == JOptionPane.NO_OPTION){
					//Logic to delete alarm 
					// TODO delete alarm or timer
					//deleteAlarms();
					if (tempAlarm instanceof AlarmTimer)
						deleteAlarms(myTimer);
					else
						deleteAlarms(tempAlarm);
				}

			}
		}, 60000);
		
	}

	/**
	 * Deleting alarm or timer object and writing it back to file
	 * Checks if alarm/timer exists in writer class then removes it from respected arraylist
	 * then it writes the updated arraylist back to the file.
	 * @param { Alarm } obj
	 */
	public void deleteAlarms(Alarm obj) {
		if (obj instanceof AlarmTimer) {
			// .indexOf returns -1 if no element is found in array
			// so we check if item is in writer array
			int index = TimerWriter.getList().indexOf(obj);
			if (index != -1) {
				System.out.println("removing timer in index");
				TimerWriter.removeElement(index);
				TimerWriter.addToJson();
			}
		} else {
			int index = AlarmWriter.getList().indexOf(obj);
			if (index != -1) {
				System.out.println("removing alarm in index");
				AlarmWriter.removeElement(index);
				AlarmWriter.addToJson();
			}
		}
	}
}
