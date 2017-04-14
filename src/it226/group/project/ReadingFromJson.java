package it226.group.project;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public final class ReadingFromJson {

    public static ArrayList<Alarm> alarmsFromJson() {
        File alarmFile = new File("data/alarms.json");
        ArrayList<Alarm> list = new ArrayList<>();
        Alarm[] alarms = null;
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(alarmFile));
            alarms = gson.fromJson(reader, Alarm[].class);
            for (Alarm a : alarms) {
                list.add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("File is empty");
        }
        return list;
    }

    public static ArrayList<AlarmTimer> timersFromJson() {
        File timerFile = new File("data/timers.json");
        ArrayList<AlarmTimer> list = new ArrayList<>();
        AlarmTimer[] timers = null;
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(timerFile));
            timers = gson.fromJson(reader, AlarmTimer[].class);
            for (AlarmTimer t : timers) {
                list.add(t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("File is empty");
        }
        return list;
    }

    public static void initializeFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
