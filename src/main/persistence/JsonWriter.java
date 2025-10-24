package persistence;

// Code adapted from: University of British Columbia CPSC 210 JSON Serialization Demo
// Source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Author: Paul Carter
// Accessed: October 22, 2025


import model.PracticeLog;
import model.User;

import org.json.JSONObject;


import java.io.*;

// Represents a writer that writes JSON representation of PracticeLog to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(PracticeLog pl) {
        JSONObject json = pl.toJson(); 
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of User (and their PracticeLog) to file
    public void writeUser(User user) {
        JSONObject json = user.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

    


}
