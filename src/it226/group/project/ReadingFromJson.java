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

    public static ArrayList<Clock> readFromJson() {
        File file = new File("data/alarms.json");
        ArrayList<Clock> list = new ArrayList<>();
        Clock[] cArr = null;
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(file));
            cArr = gson.fromJson(reader, Clock[].class);
            for (Clock c : cArr) {
                list.add(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
