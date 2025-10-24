package persistence;

import model.PracticeLog;
import model.PracticeSession;
import model.User;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPracticeLog() {
        try {
            PracticeLog pl = new PracticeLog();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPracticeLog.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPracticeLog.json");
            pl = reader.read();
            assertEquals(0, pl.sessionCount());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPracticeLog() {
        try {
            PracticeLog pl = new PracticeLog();
            pl.addSession(new PracticeSession("2025-10-18", "piano", "Valse", 90, "technique", "Romantic",
                    "improve left hand"));
            pl.addSession(new PracticeSession("2025-10-19", "guitar", "2-part invension", 120, "not a good practice",
                    "Baroque", "n/a"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPracticeLog.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPracticeLog.json");
            pl = reader.read();
            List<PracticeSession> practiceSessions = pl.getPracticeSession();
            assertEquals(2, practiceSessions.size());
            checkPracticeSession("2025-10-18", "piano", "Valse", 90, "technique", "Romantic", "improve left hand",
                    practiceSessions.get(0));
            checkPracticeSession("2025-10-19", "guitar", "2-part invension", 120, "not a good practice", "Baroque",
                    "n/a", practiceSessions.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriteUserEmptyLog() {
        try {
            PracticeLog log = new PracticeLog();
            User user = new User("EmptyUser", log);

            String destination = "./data/testWriterUserEmpty.json";
            JsonWriter writer = new JsonWriter(destination);
            writer.open();
            writer.writeUser(user);
            writer.close();

            String content = new String(Files.readAllBytes(Paths.get(destination)));
            JSONObject json = new JSONObject(content);

            assertEquals("EmptyUser", json.getString("name"));
            assertTrue(json.getJSONArray("practiceSessions").isEmpty());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
