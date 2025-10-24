package persistence;

import model.PracticeLog;
import model.PracticeSession;
import model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class JsonTest {
    protected void checkPracticeSession(String day, String instrument, String pieces,
            int duration, String comment, String category, String goal, PracticeSession practiceSession) {
        assertEquals(day, practiceSession.getDay());
        assertEquals(instrument, practiceSession.getInstrument());
        assertEquals(pieces, practiceSession.getPieces());
        assertEquals(duration, practiceSession.getDuration());
        assertEquals(comment, practiceSession.getComment());
        assertEquals(category, practiceSession.getCategory());
        assertEquals(goal, practiceSession.getGoal());
        assertEquals(day + ": " + instrument + ": " + pieces + ": " + duration + ":" 
                + comment + ": " + category + ": " + goal + ": ", practiceSession.toString());
    }
}