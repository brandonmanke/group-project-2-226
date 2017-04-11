package it226.group.project;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UI extends JFrame {
	
	private JFrame main;
	private Container mainPane;
	private JPanel buttonPanel;
	private JPanel inputPanel;
	private JButton addAlarmButton;
	private JButton addTimerButton;
	private JLabel headerLabel;
	private JScrollPane clockScrollPane;
	
	private static JTextField alarmDate;
	private static JTextField alarmTime;
	private static JTextField alarmMessage;
	private static JTextField timerMins;
	private static JTextField timerSecs;
	private static JTextField timerMessage;

	public UI() {

		main  = new JFrame();
		main.setTitle("Project 2");
		main.setSize(500, 500);

		//Panel to hold all other panels in the UI
	    Container mainPane = main.getContentPane();
		mainPane.setLayout(new GridLayout(3,1));
		
		//Data to go in first row of mainPane
		headerLabel = new JLabel("", JLabel.CENTER);
		headerLabel.setText("Alarm And Time Dashboard");
		
		//Data to go in second row of mainPane
		inputPanel = new JPanel(true);
		inputPanel.setLayout(new GridLayout(3,2));
		
		alarmDate = new JTextField();
		alarmTime = new JTextField();
		alarmMessage = new JTextField();
		timerMins = new JTextField();
		timerSecs = new JTextField();
		timerMessage = new JTextField();
		
		inputPanel.add(alarmDate);
		inputPanel.add(timerMins);
		inputPanel.add(alarmTime);
		inputPanel.add(timerSecs);
		inputPanel.add(alarmMessage);
		inputPanel.add(timerMessage);

		//Data to go in third row of mainPane
		buttonPanel = new JPanel(true);
		buttonPanel.setLayout(new FlowLayout());
		addAlarmButton = new JButton("Add Alarm");
		addTimerButton = new JButton("Add Timer");
		buttonPanel.add(addAlarmButton);
		buttonPanel.add(addTimerButton);
		
		addTimerButton.addActionListener(new ClockListeners());
		addAlarmButton.addActionListener(new ClockListeners());
		
		//Adding Three Components to the mainPane
		mainPane.add(headerLabel);
		mainPane.add(inputPanel);
		mainPane.add(buttonPanel);
		
		//Adding Listeners To Buttons
		//addAlarmButton.addActionListener((ActionListener) this);
		//addTimerButton.addActionListener((ActionListener) this);
		
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
