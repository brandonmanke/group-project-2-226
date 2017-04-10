package it226.group.project;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public final class ReadingFromJson {

    public static ArrayList<Alarm> readFromJson() {
        File file = new File("data/alarms.json");
        ArrayList<Alarm> list = new ArrayList<>();
        Alarm[] alarms = null;
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(file));
            alarms = gson.fromJson(reader, Alarm[].class);
            for (Alarm a : alarms) {
                list.add(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
