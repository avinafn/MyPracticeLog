package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

/*
 * Represents a log of practice sessions containing a list of sessions practiced by a user
   Keeps track of all PracticeSession entries and allows access to
   information such as total practice time and number of sessions
 */
public class PracticeLog implements Writable {

    private List<PracticeSession> practiceSession;
    // private int total;

    /*
     * EFFECTS: Initializes this PracticeLog with an empty list of PracticeSession;
     * the list is ready to have sessions added.
     */
    public PracticeLog() {
        this.practiceSession = new ArrayList<>();
    }

    /*
     * REQUIRES: Session is not null EFFECTS: Adds the session to the list of
     * sessions
     */
    public void addSession(PracticeSession session) {
        practiceSession.add(session);
    }

    /*
     * EFFECTS: Returns the total practice time (in minutes) across all sessions in
     * this PracticeLog. If there are no sessions, returns 0.
     */
    public int totalPracticeTime() {
        int total = 0;
        for (PracticeSession practiceSession : this.practiceSession) {

            total += practiceSession.getDuration();
        }
        return total;

    }

    /*
     * EFFECTS: Returns the number of PracticeSession objects currently stored in
     * this PracticeLog.
     */
    public int sessionCount() {
        // int count = 0;
        // for (PracticeSession practiceSession : this.practiceSession) {
        // count++;
        // }
        // return count;
        return practiceSession.size();

    }

    // EFFECTS: Returns the pointer to the list of practice session (does not get
    // every element in the list)
    public List<PracticeSession> getPracticeSession() {
        return practiceSession;
    }

    public void setPracticeSession(List<PracticeSession> practiceSession) {
        this.practiceSession = practiceSession;
    }

    // EFFECTS: Returns the pieces practice in the practice log
    public List<String> getAllPieces() {
        List<String> piecesList = new ArrayList<>();
        for (PracticeSession practiceSession : this.practiceSession) {
            piecesList.add(practiceSession.getPieces());

        }
        return piecesList;

    }

    // EFFECTS: Returns and shows each element in a session
    public String showPracticeSession(int i) {
        String day = practiceSession.get(i).getDay();
        String instrument = practiceSession.get(i).getInstrument();
        String pieces = practiceSession.get(i).getPieces();
        // String focusArea = practiceSession.get(i).getFocusArea();
        String comment = practiceSession.get(i).getComment();
        int duration = practiceSession.get(i).getDuration();
        String category = practiceSession.get(i).getCategory();
        String goal = practiceSession.get(i).getGoal();

        return "Practice " + Integer.toString(i + 1) + ":\n" + "day: " + day + "\n" + "instrument: " + instrument + "\n"
                + "pieces: " + pieces + "\n"
                // + "focus Area: " + focusArea + "\n"
                + "comment: " + comment + "\n" + "duration: " + duration + "\n" + "category: " + category + "\n"
                + "goal: " + goal + "\n";
    }

    public List<PracticeSession> getSessions() {
        return practiceSession;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("practiceSessions", practiceSessionsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray practiceSessionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (PracticeSession p : practiceSession) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }

}
