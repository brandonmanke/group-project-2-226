package it226.group.project;

//import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Base class of both AlarmTimer & Alarm
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public abstract class Clock {
    private String optionalMessage;

    public Clock() {
        super();
    }

    public Clock(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

    public String getOptionalMessage() { return optionalMessage; }

    public void setOptionalMessage(String optionalMessage) {
        this.optionalMessage = optionalMessage;
    }

    public Clock writeToJson() {
        //Gson gson = new Gson();
        File file = new File("data/alarms.json");
        try (FileWriter writer = new FileWriter(file)) {
           // gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public abstract Clock readFromJson();
}
