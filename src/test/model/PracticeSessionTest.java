package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PracticeSessionTest {
    private PracticeSession practicesessiontest;
    


    
    @BeforeEach
    void runBefore() {
        practicesessiontest = new PracticeSession("Monday", "Piano", "Fur Elise", 30, "Left hand",
         List.of("Focus on the second movement"), "Classical", "memorize the notes");

    }

    @Test
    void testConstructorSession() {
        assertEquals("Monday", practicesessiontest.getDay());
        assertEquals("Piano", practicesessiontest.getInstrument());
        assertEquals("Fur Elise", practicesessiontest.getPieces());
        assertEquals(30, practicesessiontest.getDuration());
        assertEquals("Left hand", practicesessiontest.getFocusArea());
        assertEquals("Focus on the second movement", practicesessiontest.getComment());
        assertEquals("Classical", practicesessiontest.getCategory());
        assertEquals("memorize the notes", practicesessiontest.getGoal());
        
        

    }

    @Test
    void getDayTest() {
        assertEquals("Monday", practicesessiontest.getDay());

    }

    @Test
    void setDayTest() {
        practicesessiontest.setDay("Wednesday");
        assertEquals("Wednesday", practicesessiontest.getDay());
        practicesessiontest.setDay("Sunday");
        assertEquals("Sunday", practicesessiontest.getDay());

        
    }

    @Test
    void getInstrumentTest() {
        assertEquals("piano", practicesessiontest.getInstrument());
    }

    @Test
    void setInstrumentTest() {
        practicesessiontest.setInstrument("violin");
        assertEquals("violin", practicesessiontest.getInstrument());
    }

    @Test
    void getPiecesTest() {
        assertEquals("Fur Elise", practicesessiontest.getPieces());
    }

    @Test
    void setPiecesTest() {
        practicesessiontest.setPieces("Nocturne");
        assertEquals("Nocturne", practicesessiontest.getPieces());
    }

    @Test
    void getDurationTest() {
        assertEquals(40, practicesessiontest.getDuration());
    }

    @Test
    void setDurationTest() {
        practicesessiontest.setDuration(10);
        assertEquals(10, practicesessiontest.getDuration());
    }

    @Test
    void getFocusAreaTest() {
        assertEquals("left hand practice", practicesessiontest.getFocusArea());
    }

    @Test
    void setFocusAreaTest() {
        practicesessiontest.setFocusArea("Solfege");
        assertEquals("Solfege", practicesessiontest.getFocusArea());
    }

    @Test
    void getCommentsTest() {
        assertEquals("Good practice", practicesessiontest.getComment());
    }

    @Test
    void setCommentsTest() {
        practicesessiontest.setComment(List.of("Waste of time!"));
        assertEquals("Waste of time!", practicesessiontest.getComment());
    }

    @Test
    void getCategoryTest() {
        assertEquals("Classical", practicesessiontest.getComment());
    }

    @Test
    void setCategoryTest() {
        practicesessiontest.setCategory("Romantic");
        assertEquals("Romantic", practicesessiontest.getCategory());
    }

    @Test
    void getGoal() {
        assertEquals("memorize the notes", practicesessiontest.getGoal());
    }

    @Test
    void setGaol() {
        practicesessiontest.setGoal("Read the Romantic period information");
        assertEquals("Read the Romantic period information", practicesessiontest.getGoal());
    }

    
}    

