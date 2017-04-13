package it226.group.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class UI extends JFrame {
	
	private JFrame main;
	private JButton addAlarmButton;
	private JButton addTimerButton;
	private JLabel headerLabelAlarm;
	private JLabel headerLabelTimer;
	
	private JTabbedPane tabbedPane;
	private JPanel alarmPanel;
	private JPanel timerPanel;
	
	private static JTextField alarmDate;
	private static JTextField alarmTime;
	private static JTextField alarmMessage;
	private static JTextField timerMins;
	private static JTextField timerSecs;
	private static JTextField timerMessage;
	private static JTextField timerHr;
	
	private JLabel hourLabel;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JLabel alarmMessLabel;
	private JLabel minsLabel;
	private JLabel secsLabel;
	private JLabel timerMessLabel;

	public UI() {

		main  = new JFrame();
		main.setTitle("Project 2");
		main.setSize(500, 500);
		
		//Making a tabbed pane 
		tabbedPane = new JTabbedPane();
		
		//First tab for the alarms 
		alarmPanel = new JPanel(true);
		tabbedPane.addTab("Add Alarm", alarmPanel);
		alarmPanel.setLayout(new GridLayout(8,1));
		
		//Second Tab for timers
		timerPanel = new JPanel(true);
		tabbedPane.addTab("Add Timer", timerPanel);
		timerPanel.setLayout(new GridLayout(10,1));
		
		main.add(tabbedPane);
		
		//Headers for two panels
		headerLabelAlarm = new JLabel("", JLabel.CENTER);
		headerLabelAlarm.setText("Add Alarm Dashboard");
		headerLabelAlarm.setFont(new Font("Serif", Font.BOLD, 20));
		headerLabelTimer = new JLabel("", JLabel.CENTER);
		headerLabelTimer.setText("Add Timer Dashboard");
		headerLabelTimer.setFont(new Font("Serif", Font.BOLD, 20));
		headerLabelAlarm.setForeground(Color.blue);
		headerLabelTimer.setForeground(Color.blue);
		
		//Text fields for two panels 		
		alarmDate = new JTextField();
		alarmTime = new JTextField();
		alarmMessage = new JTextField();
		timerMins = new JTextField();
		timerSecs = new JTextField();
		timerMessage = new JTextField();
		timerHr = new JTextField();
		
		//Labels for the two panels
		dateLabel = new JLabel("Alarm Date (MM/DD/YYYY)", JLabel.CENTER);
		timeLabel = new JLabel("Alarm Time (HH:MM:SS am/pm)", JLabel.CENTER);
		alarmMessLabel= new JLabel("Alarm Message", JLabel.CENTER);
		minsLabel = new JLabel("Timer Minutes", JLabel.CENTER);
		secsLabel = new JLabel("Timer Seconds", JLabel.CENTER);
		timerMessLabel= new JLabel("Timer Message", JLabel.CENTER);
		hourLabel= new JLabel("Timer Hours", JLabel.CENTER);

		//Buttons for the two panels 
		addAlarmButton = new JButton("Add Alarm");
		addTimerButton = new JButton("Add Timer");
		
		//To be able to listen to when the button is clicked
		addTimerButton.addActionListener(new ClockListeners());
		addAlarmButton.addActionListener(new ClockListeners());
		
		//Adding the components to the panels 
		alarmPanel.add(headerLabelAlarm);
		alarmPanel.add(dateLabel);
		alarmPanel.add(alarmDate);
		alarmPanel.add(timeLabel);
		alarmPanel.add(alarmTime);
		alarmPanel.add(alarmMessLabel);
		alarmPanel.add(alarmMessage);
		alarmPanel.add(addAlarmButton);
		
		timerPanel.add(headerLabelTimer);
		timerPanel.add(hourLabel);
		timerPanel.add(timerHr);
		timerPanel.add(minsLabel);
		timerPanel.add(timerMins);
		timerPanel.add(secsLabel);
		timerPanel.add(timerSecs);
		timerPanel.add(timerMessLabel);
		timerPanel.add(timerMessage);
		timerPanel.add(addTimerButton);

		//add names to JButtons
		addAlarmButton.setName("alarm");
		addTimerButton.setName("timer");

		main.setVisible(true);
		
	    //To clean up interface and close it when close the window 
	    main.pack();
	    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static JTextField getAlarmDate(){
		return alarmDate;
	}
	
	public static JTextField getAlarmTime(){
		return alarmTime;
	}
	
	public static JTextField getAlarmMessage(){
		return alarmMessage;
	}

	public static JTextField getTimerHr() { return timerHr; }
	
	public static JTextField getTimerMins(){
		return timerMins;
	}
	
	public static JTextField getTimerSecs(){
		return timerSecs;
	}
	
	public static JTextField getTimerMessage(){
		return timerMessage;
		
	}
	
}
