package it226.group.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import static it226.group.project.UI.*;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public class ClockListeners implements ActionListener {
	
	final long TIME_ZONE_MS = 21600000;
	
	//date format
	DateFormat startDate = new SimpleDateFormat("MM/dd/yyyy");
	Date finalDate;

	
	//timer format
	DateFormat timerFormat = new SimpleDateFormat("hh:mm:ss a");
	Date finalTimer; 
	
	
	String year;
	String month;
	String day;
	String hour;
	String minute;
	String seconds;
	
	String fullDate;
	
	Countdown countdown = new Countdown();

	public void actionPerformed(ActionEvent e) {
		
		JButton buttonPressed = (JButton) e.getSource();
		String buttonName = buttonPressed.getName();

		//if button name equals alarm, do alarm actions
		if (buttonName.equals("alarm")) {
			
			String alarmDateEntered = getAlarmDate().getText();
			String alarmTimeEntered = getAlarmTime().getText();
			String alarmMessageEntered = getAlarmMessage().getText();
			
			//try to parse the input to a Date type
			try {
				finalDate = startDate.parse(alarmDateEntered);
				finalTimer = timerFormat.parse(alarmTimeEntered);
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//create new alarm object with parameters and write to json file
			Alarm alarm = new Alarm(finalDate, alarmMessageEntered);
			
			//get total time of date and time entered and add together
			long liftoffTime = finalDate.getTime() + finalTimer.getTime() - TIME_ZONE_MS;
			alarm.setDate(new Date(liftoffTime)); 

			System.out.println(alarm.getDate());
			//System.out.println(alarm.getTime());		
			//System.out.println(alarm.getOptionalMessage());

			alarm.writeToJson();
			countdown.runAlarm();
			
		}
		
		//if button name equals timer, do alarm actions
		if (buttonName.equals("timer")) {

			String timerHoursEntered = getTimerHr().getText();
			String timerMinsEntered = getTimerMins().getText();
			String timerSecsEntered = getTimerSecs().getText();
			String timerMessageEntered = getTimerMessage().getText();
			
			//change string input to an int.... still needs exception handling
			int timerHoursInt = Integer.parseInt(timerHoursEntered);
			int timerMinsInt = Integer.parseInt(timerMinsEntered);
			int timerSecsInt = Integer.parseInt(timerSecsEntered);

			// Add date object to this
			//create new myTimer object with parameters and write to json file
			AlarmTimer timer = new AlarmTimer(new Date(), timerHoursInt, timerMinsInt, timerSecsInt, timerMessageEntered);
			
			
			timer.writeToJson();
			countdown.runTimer();
		}

	}

}
