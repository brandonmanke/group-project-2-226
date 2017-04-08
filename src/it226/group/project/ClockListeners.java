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
	
	//date format
	DateFormat startDate = new SimpleDateFormat("mm/dd/yyyy");
	Date finalDate;
	
	//timer format
	DateFormat timerFormat = new SimpleDateFormat("hh:mm:ss a");
	Date finalTimer;

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
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//create new alarm object with parameters and write to json file
			Alarm alarm = new Alarm(finalDate, alarmMessageEntered);
			alarm.writeToJson();
		}
		
		//if button name equals timer, do alarm actions
		if (buttonName.equals("timer")) {
	
			String timerMinsEntered = getTimerMins().getText();
			String timerSecsEntered = getTimerSecs().getText();
			String timerMessageEntered = getTimerMessage().getText();
			
			//change string input to an int.... still needs exception handling
			int timerSecsInt = Integer.parseInt(timerSecsEntered);
			int timerMinsInt = Integer.parseInt(timerMinsEntered);
			
			//create new myTimer object with parameters and write to json file
			AlarmTimer timer = new AlarmTimer(timerMessageEntered, timerMinsInt, timerSecsInt);
			timer.writeToJson();
			
			System.out.println("-----" + timerSecsInt+ "-----");
			System.out.println("-----" + timerMinsInt + "-----");
			System.out.println("-----" + timerMessageEntered + "-----");
		}

	}

}
