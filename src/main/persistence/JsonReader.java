package persistence;

// Code adapted from: University of British Columbia CPSC 210 JSON Serialization Demo
// Source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Author: Paul Carter




import model.PracticeLog;
import model.PracticeSession;
import model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public PracticeLog read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePracticeLog(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    public User readUser() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        String name = jsonObject.getString("name");        
        PracticeLog log = parsePracticeLog(jsonObject);
        return new User(name, log);
    }


    // EFFECTS: parses PracticeLog from JSON object and returns it
    private PracticeLog parsePracticeLog(JSONObject jsonObject) {
        PracticeLog pl = new PracticeLog();
        addSessions(pl, jsonObject);
        return pl;
    }

      // MODIFIES: pl
    // EFFECTS: parses Practice Sessions from JSON object and adds them to PracticeLog
    private void addSessions(PracticeLog pl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("practiceSessions");
        for (Object json : jsonArray) {
            JSONObject nextSession = (JSONObject) json;
            addSession(pl, nextSession);
        }
    }

    // MODIFIES: pl
    // EFFECTS: parses Practice session from JSON object and adds it to PracticeLog
    private void addSession(PracticeLog pl, JSONObject jsonObject) {
        String day = jsonObject.getString("day");
        String instrument = jsonObject.getString("instrument");
        String pieces = jsonObject.getString("pieces");
        int duration = jsonObject.getInt("duration");
        String comment = jsonObject.getString("comment");
        String category = jsonObject.getString("category");
        String goal = jsonObject.getString("goal");
        PracticeSession session = new PracticeSession(day, instrument, pieces, duration, comment, category, goal);
        pl.addSession(session);
    }

}
