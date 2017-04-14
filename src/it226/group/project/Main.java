package it226.group.project;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * TODO: Test writing to json and reading back from it
 *       Implement UI of alarm system
 *       Connect everything together and make sure it works
 * Main method of our Group Project 2
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public class Main {

    public static void main(String[] args) {
    	
        File file = new File("data/alarms.json");
        File file2 = new File("data/timers.json");
        ReadingFromJson.initializeFile(file);
        ReadingFromJson.initializeFile(file2);
        AlarmWriter.initializeWriter(ReadingFromJson.alarmsFromJson());
        TimerWriter.initializeWriter(ReadingFromJson.timersFromJson());
        UI gui = new UI();
        
        Countdown countdown = new Countdown();
        countdown.runAlarm();
        countdown.runTimer();
       
        

    }
    
 /*   public static void readAtStart(){
    	ArrayList<Alarm> testList = AlarmWriter.getList();
    	Countdown countdown = new Countdown();
    	
    	for(int i = 0; i < testList.size(); i++){
    		if(testList.get(i).getIsFired()){
    			countdown.deleteAlarms(testList.get(i));
    		}
    	} 
    } */
}


