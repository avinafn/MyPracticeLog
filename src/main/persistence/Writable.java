package persistence;

// Code adapted from: University of British Columbia CPSC 210 JSON Serialization Demo
// Source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Author: Paul Carter
// Accessed: October 22, 2025


import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();

}
