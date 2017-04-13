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
public final class AlarmWriter {
    // this is a really bad way of doing this writing, I'm so sorry.
    private static ArrayList<Alarm> list = new ArrayList<Alarm>();

    public static ArrayList<Alarm> getList() { return list; }

    public static void initializeWriter(ArrayList<Alarm> list) {
        AlarmWriter.list = list;
    }

    public static Alarm removeElement(int index) {
        Alarm temp = list.get(index);
        list.remove(index);
        return temp;
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
    }

    public static void addToJson() {
        Gson gson = new Gson();
        File file = new File("data/alarms.json");
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
