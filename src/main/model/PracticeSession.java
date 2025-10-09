package model;

import java.util.List;

// A class representing a practice session having a date, instrument, pieces, duration, focusarea and comments
public class PracticeSession {
    private String comment;
    private String day;
    private String instrument;
    private String pieces;
    private int duration;
    private String focusArea;
    private List<String> comments;


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
    public PracticeSession(String day, String instrument, String pieces, int duration, String focusArea) {
        // TODO

    }

    public String getDate() {
        return day; // TODO
    }

    public void setDate(int date) {
        this.day = day; // TODO
    }

    public String getInstrument() {
        return instrument; // TODO
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument; // TODO
    }

    public String getPieces() {
        return pieces; // TODO
    }

    public void setPieces(String pieces) {
        this.pieces = pieces; // TODO
    } 

    public int getDuration() {
        return duration; // TODO
    }

    public void setDuration(int duration) {
        this.duration = duration; // TODO
    }

    public String getFocusArea() {
        return focusArea; // TODO
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea; // TODO
    }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
