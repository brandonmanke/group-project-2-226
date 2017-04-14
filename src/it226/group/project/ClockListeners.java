package it226.group.project;

import static it226.group.project.UI.getAlarmDate;
import static it226.group.project.UI.getAlarmMessage;
import static it226.group.project.UI.getAlarmTime;
import static it226.group.project.UI.getTimerHr;
import static it226.group.project.UI.getTimerMessage;
import static it226.group.project.UI.getTimerMins;
import static it226.group.project.UI.getTimerSecs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
	
	//dat and timer format
	DateFormat dateAndTimeFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	Date finalDateAndTime; 
	
	Calendar cal;
	
	String year;
	String month;
	String day;
	String hour;
	String minute;
	String seconds;
	boolean isFired = false;
	String fullDate;
	
	Countdown countdown = new Countdown();
	
	String[] options = {"Okay"};

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
				

			
			
			//create new alarm object with parameters and write to json file
			Alarm alarm = new Alarm(finalDate, alarmMessageEntered, isFired);
			
			//get total time of date and time entered and add together
			long liftoffTime = finalDate.getTime() + finalTimer.getTime() - TIME_ZONE_MS;
			alarm.setDate(new Date(liftoffTime)); 

			System.out.println(alarm.getDate());
			//System.out.println(alarm.getTime());		
			//System.out.println(alarm.getOptionalMessage());

			alarm.writeToJson();
			
			} catch (ParseException e1) {
				JOptionPane.showOptionDialog(null, "Please enter a date/time with the correct format", "ERROR!!", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			}
			countdown.runAlarm();
			
			
			
		}
		
		//if button name equals timer, do alarm actions
		if (buttonName.equals("timer")) {

			String timerHoursEntered = getTimerHr().getText();
			String timerMinsEntered = getTimerMins().getText();
			String timerSecsEntered = getTimerSecs().getText();
			String timerMessageEntered = getTimerMessage().getText();
			
			//change string input to an int.... still needs exception handling
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
	        LocalDateTime now = LocalDateTime.now();
	        String stringDate = dtf.format(now).toString();
	        
	        try {
				finalDateAndTime = dateAndTimeFormat.parse(stringDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
			int timerHoursInt = Integer.parseInt(timerHoursEntered);
			int timerMinsInt = Integer.parseInt(timerMinsEntered);
			int timerSecsInt = Integer.parseInt(timerSecsEntered);
		
			// Add date object to this
			//create new myTimer object with parameters and write to json file
			AlarmTimer timer = new AlarmTimer(finalDateAndTime, timerHoursInt, timerMinsInt, timerSecsInt, timerMessageEntered, isFired);
			
			long milliseconds = (timerSecsInt * 1000) + (timerMinsInt * 60000) + (timerHoursInt * 3600000);
			
			timer.setMilliseconds(milliseconds);
			
			long liftofftime = finalDateAndTime.getTime() + timer.getMilliseconds();
	
			timer.setDate(new Date(liftofftime));
		
			timer.writeToJson();
			
			} catch(NumberFormatException numExcep){
				JOptionPane.showOptionDialog(null, "Please enter NUMBERS into ALL fields", "ERROR!!", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			}
			countdown.runTimer();
		}

	}

}
