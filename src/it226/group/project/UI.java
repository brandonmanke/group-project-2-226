package it226.group.project;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UI extends JFrame
{
	
	private JFrame main;
	private Container mainPane;
	private JPanel buttonPanel;
	private JButton addAlarmButton;
	private JButton addTimerButton;
	private JLabel headerLabel;
	private JTextArea clockDashboard;
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
		clockDashboard = new JTextArea(6,50);
		clockScrollPane = new JScrollPane(clockDashboard);
		
		//Data to go in third row of mainPane
		buttonPanel = new JPanel(true);
		buttonPanel.setLayout(new FlowLayout());
		addAlarmButton = new JButton("Add Alarm");
		addTimerButton = new JButton("Add Timer");
		buttonPanel.add(addAlarmButton);
		buttonPanel.add(addTimerButton);
		
		//Adding Three Components to the mainPane
		mainPane.add(headerLabel);
		mainPane.add(clockScrollPane);
		mainPane.add(buttonPanel);
		
		main.setVisible(true);
		
		 //To clean up interface and close it when close the window 
	       main.pack();
	       main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	       
	}
	
}
