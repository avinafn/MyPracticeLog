package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class PracticeLogTest {

    private PracticeLog practicelogtest;

    private PracticeSession session1;
    private PracticeSession session2;
    private PracticeSession session3;

    private List<PracticeSession> sessions;




    @BeforeEach
    void runBefore() {
        practicelogtest = new PracticeLog();
        session1 = new PracticeSession("Sat", "guitar", "Valse", 20, "chords", 
        List.of("Focus on the next part in the upcoming practice"),"Romantic", "practice for 30 mins");
        session2 = new PracticeSession("Sat", "guitar", "Nocturne", 0, "chords", 
        List.of("still problem playing the chords"), "Romantic", "practice the first page");
        session3 = new PracticeSession("Sat", "guitar", "Persian Theme", 10, "chords",
        List.of("Listen to the original song"), "Pop", "Record yourslef");
        sessions = new ArrayList<>();
    }

    @Test
    void testConstructorLog() {
        assertEquals(0, practicelogtest.sessionCount());
    }


    @Test
    void addSessionTest() {
        assertEquals(0, practicelogtest.sessionCount());
        practicelogtest.addSession(session1);
        assertEquals(1, practicelogtest.sessionCount());
    }

    @Test
    void totalPracticeTimeTest() {
        assertEquals(0, practicelogtest.totalPracticeTime());
        practicelogtest.addSession(session1);
        assertEquals(20, practicelogtest.totalPracticeTime());
        practicelogtest.addSession(session3);
        assertEquals(30, practicelogtest.totalPracticeTime());


    }

    @Test
    void sessionCountTest() {
        assertEquals(0, practicelogtest.sessionCount());
        practicelogtest.addSession(session1);
        assertEquals(1, practicelogtest.sessionCount());
        practicelogtest.addSession(session2);
        assertEquals(2, practicelogtest.sessionCount());

    }

    @Test
    void getPracticeSessionTest() {
        assertEquals(session1, practicelogtest.getPracticeSession());
    }

    @Test
    void setPracticeSessionTest() {
        assertEquals(sessions, practicelogtest.getPracticeSession());
        sessions.add(session2);
        practicelogtest.setPracticeSession(sessions);
        assertEquals(sessions, practicelogtest.getPracticeSession());
        sessions.add(session3);
        practicelogtest.setPracticeSession(sessions);
        assertEquals(sessions, practicelogtest.getPracticeSession());

    }

    @Test
    void getAllPiecesTest() {
        practicelogtest.addSession(session1);
        practicelogtest.addSession(session2);
        practicelogtest.addSession(session3);

        List<String> expectedPieces = new ArrayList<>();

        expectedPieces.add("Valse");
        expectedPieces.add("Nocturne");
        expectedPieces.add("Persian Theme");

        assertEquals(expectedPieces, practicelogtest.getAllPieces());
    }
    

}
