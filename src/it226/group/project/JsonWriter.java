package it226.group.project;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public final class JsonWriter {
    // this is a really bad way of doing this writing, I'm so sorry.
    private static ArrayList<Alarm> list = new ArrayList<>();

    public static ArrayList<Alarm> getList() { return list; }

    public static void initializeWriter(ArrayList<Alarm> list) {
        JsonWriter.list = list;
    }

    public static void addToJson(Alarm obj) {
        list.add(obj);
        Gson gson = new Gson();
        File file = new File("data/alarms.json");
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //list = ReadingFromJson.readFromJson();
        for (Alarm a : ReadingFromJson.readFromJson()) {
            System.out.println("Things in json: " + a.getTime());
        }
    }
}
