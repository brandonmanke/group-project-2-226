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

public class UI extends JFrame
{
	
	private JFrame main;
	private Container mainPane;
	private JPanel buttonPanel;
	private JPanel inputPanel;
	private JButton addAlarmButton;
	private JButton addTimerButton;
	private JLabel headerLabel;
	private JScrollPane clockScrollPane;
	
	
	public UI(){
		
		
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
		
		JTextField alarmDate = new JTextField();
		JTextField alarmTime = new JTextField();
		JTextField alarmMessage = new JTextField();
		JTextField timerMins = new JTextField();
		JTextField timerSecs = new JTextField();
		JTextField timerMessage = new JTextField();
		
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
		
		//Adding Three Components to the mainPane
		mainPane.add(headerLabel);
		mainPane.add(inputPanel);
		mainPane.add(buttonPanel);
		
		//Adding Listeners To Buttons
		//addAlarmButton.addActionListener((ActionListener) this);
		//addTimerButton.addActionListener((ActionListener) this);
		
		
		main.setVisible(true);
		
	    //To clean up interface and close it when close the window 
	    main.pack();
	    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       
	       
	       
	}
	
}
