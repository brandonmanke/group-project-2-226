package it226.group.project;

/**
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
// This may not be needed. It depends on if alarm timer needs a specific implementation of writing and reading to json
public interface IClock {

    // BROKEN tbh fix this, Clock only supports getOptionalMessage()
    // therefore when we read from the json file and put everything into a clock arraylist
    // we can only get the optional message, which is completely useless actually gg
    // if clock has a date object then it is actually the same thing as alarm so maybe
    // we just need alarm and alarm timer and no clock class, maybe make clock a interface
    //public Clock readFromJson() {
    //    ReadingFromJson.readFromJson();
    //    return this;
    //}

    //Alarm writeToJson();
    //Alarm readJson();

}
