package model;

import java.util.ArrayList;
import java.util.List;

/*
 * Represents a log of practice sessions containing a list of sessions practiced by a user
   Keeps track of all PracticeSession entries and allows access to
   information such as total practice time and number of sessions
 */
public class PracticeLog {

    private List<PracticeSession> practiceSession;

    /*
     * EFFECTS: Initializes this PracticeLog with an empty list of PracticeSession; 
     *          the list is ready to have sessions added.
     */
    public PracticeLog() {
        this.practiceSession = new ArrayList<>();
    }


    /*
     * REQUIRES: Session is not null
     * MODIFIES: this
     * EFFECTS: Adds the session to the list of sessions
     */
    public void addSession(PracticeSession session) {
        practiceSession.add(session);
    }


    /*
     * EFFECTS: Returns the total practice time (in minutes) across all sessions
                in this PracticeLog. If there are no sessions, returns 0.
     */
    public int totalPracticeTime() {
        int total = 0;
        for (PracticeSession practiceSession : this.practiceSession) {
            total += practiceSession.getDuration();
        }
        return total;

    }


    /*
     * EFFECTS: Returns the number of PracticeSession objects currently stored
                in this PracticeLog.
     */
    public int sessionCount() {
        //int count = 0;
        //for (PracticeSession practiceSession : this.practiceSession) {
        //    count++;
        //}
        //return count;
        return practiceSession.size();

    }

    public List<PracticeSession> getPracticeSession() {
        return practiceSession; 
    }

    public void setPracticeSession(List<PracticeSession> practiceSession) {
        this.practiceSession = practiceSession;
    }

    //method to return the pieces practice in the practice log
    public List<String> getAllPieces() {
        List<String> piecesList = new ArrayList<>();
        for (PracticeSession practiceSession : this.practiceSession) {
            piecesList.add(practiceSession.getPieces());

        }
        return piecesList;

    }

}
