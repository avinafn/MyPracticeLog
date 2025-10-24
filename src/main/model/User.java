package model;

import org.json.JSONObject;
import persistence.Writable;

/*
 * Represents a user (musician or student) who logs practice sessions.
   Each User has a name and a PracticeLog that records all their
   PracticeSession entries.
 */
public class User implements Writable {

    private String name;
    private PracticeLog log;


    /*
     * REQUIRES: name is a non-zero length string and log is not null
     * EFFECTS: Initializes this User with the given name and PracticeLog.
                The user's name is set to name, and their log is set to the provided log
     */
    public User(String name, PracticeLog log) {
        this.name = name;
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PracticeLog getLog() {
        return log;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("practiceSessions", log.toJson()); 
        return json;
    }

   

    
}
