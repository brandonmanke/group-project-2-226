package it226.group.project;

/**
 * Abstract clock class that helps define similarities between both Alarm and myTimer objects
 * @author Brandon Manke
 * @author Colin Koepke
 * @author Ben Dworkin
 */
public abstract class Clock {
    public abstract Clock writeToJson();
    public abstract Clock readFromJson();
}
