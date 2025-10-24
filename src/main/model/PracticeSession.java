package model;

import java.util.List;

import org.json.JSONObject;

import persistence.Writable;

// A class representing a practice session having a date, instrument, pieces, duration, focusarea and comments
public class PracticeSession implements Writable {
    private String day;
    private String instrument;
    private String pieces;
    private int duration;
    //private String focusArea;
    private String comment;
    private String category;
    private String goal;



    /*
     * REQUIRES: duration >= 0
     * EFFECTS: Initializes this PracticeSession with the provided values.
                - this.date is set to date
                - this.instrument is set to instrument
                - this.pieces is set to  pieces
                - If duration >= 0 then this.durationMinutes is set to duration
                  Otherwise this.duration is set to 0.
                - this.focusArea is set to focusArea
     */
    public PracticeSession(String day, String instrument, String pieces, int duration,
            String comment, String category, String goal) {

        this.day = day;
        this.instrument = instrument;
        this.pieces = pieces;
        this.duration = duration;
        //this.focusArea = focusArea;
        this.comment = comment;
        this.category = category;
        this.goal = goal;

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day; 
    }

    public String getInstrument() {
        return instrument; 
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument; 
    }

    public String getPieces() {
        return pieces; 
    }

    public void setPieces(String pieces) {
        this.pieces = pieces; 
    } 

    public int getDuration() {
        return duration; 
    }

    public void setDuration(int duration) {
        this.duration = duration; 
    }

    //public String getFocusArea() {
    //    return focusArea; 
    //}

    //public void setFocusArea(String focusArea) {
    //    this.focusArea = focusArea; 
    //}
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    // EFFECTS: returns string representation of this practiceSession
    public String toString() {
        return day + ": " + instrument + ": " + pieces + ": " + duration + ":" 
            + comment + ": " + category + ": " + goal + ": ";
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("day", day);
        json.put("instrument", instrument);
        json.put("pieces", pieces);
        json.put("duration", duration);
        json.put("comment", comment);
        json.put("category", category);
        json.put("goal", goal);
        return json;
    }

}
