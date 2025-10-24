package persistence;

// Code adapted from: University of British Columbia CPSC 210 JSON Serialization Demo
// Source: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
// Author: Paul Carter

import model.PracticeLog;
import model.PracticeSession;
import model.User;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
public class JsonReaderTest extends JsonTest {

    // Tests whether the exception catches the invalid pathway
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            PracticeLog pl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // Tests whether the method reads and empty file
    @Test
    void testReaderEmptyPracticeLog() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPracticeLog.json");
        try {
            PracticeLog pl = reader.read();
            assertEquals(0, pl.sessionCount());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // Tests whether the method reads a general file (with 2 elements added to the list in this case)
    @Test
    void testReaderGeneralPracticeLog() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPracticeLog.json");
        try {
            PracticeLog pl = reader.read();
            List<PracticeSession> practiceSessions = pl.getPracticeSession();
            assertEquals(2, practiceSessions.size());
            checkPracticeSession("2025-10-22", "piano", "Fur Elise", 30, "focused on left hand", 
                    "Classical", "improve fingering", practiceSessions.get(0));
            
            checkPracticeSession("2025-10-20", "violin", "Moonlight", 45, "slow practice", 
                    "Classical", "prepare recital", practiceSessions.get(1));
            
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // Tests whether it reads the User class with an empty log
    @Test
    void testReaderUser() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPracticeLog.json");
        try {
            User user = reader.readUser();
            assertEquals("Avin", user.getName());
            PracticeLog log = user.getLog();
            assertEquals(0, log.sessionCount());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // Tests whether it reads the User class with a log with 2 practiceSessions
    @Test
    void testReaderUser2() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPracticeLog.json");
        try {
            User user = reader.readUser();
            assertEquals("Avin", user.getName());
            PracticeLog log = user.getLog();
            assertEquals(2, log.sessionCount());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }



}
