package it226.group.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public final class TimerWriter {
    private static ArrayList<AlarmTimer> list = new ArrayList<>();

    public static ArrayList<AlarmTimer> getList() { return list; }

    public static void initializeWriter(ArrayList<AlarmTimer> list) {
        TimerWriter.list = list;
    }

    public static void addToJson(AlarmTimer obj) {
        list.add(obj);
        Gson gson = new Gson();
        File file = new File("data/timers.json");
        for (AlarmTimer a : list)
            System.out.println("\n" + a.toString());

        try (FileWriter writer2 = new FileWriter(file)) {
            gson.toJson(list, writer2);
            //System.out.println("IN TIMER WRITER, AFTER JSON");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
