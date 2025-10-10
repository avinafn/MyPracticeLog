package model;

import java.util.List;

// A class representing a practice session having a date, instrument, pieces, duration, focusarea and comments
public class PracticeSession {
    private String day;
    private String instrument;
    private String pieces;
    private int duration;
    private String focusArea;
    private List<String> comments;
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
            String focusArea, List<String> comments, String categoty, String goal) {

        this.day = day;
        this.instrument = instrument;
        this.pieces = pieces;
        this.duration = duration;
        this.focusArea = focusArea;
        this.comments = comments;
        this.category = categoty;
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

    public String getFocusArea() {
        return focusArea; 
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea; 
    }
    
    public List<String> getComment() {
        return comments;
    }

    public void setComment(List<String> comment) {
        this.comments = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categoty) {
        this.category = category;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

}
