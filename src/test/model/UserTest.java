package model;

//import static org.junit.Assert.assertEquals;

//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class UserTest {
    private User userTest;
    private PracticeLog log;

    @BeforeEach
    void runBefore() {
        log = new PracticeLog();
        userTest = new User("Avin", log);
    }

    @Test
    public void testConstructorUser() {
        assertEquals("Avin", userTest.getName());
        assertEquals(log, userTest.getLog());
    }


    @Test
    public void getNameTest() {
        assertEquals("Avin", userTest.getName());

    }

    @Test
    public void setNameTest() {
        userTest.setName("Tara");
        assertEquals("Tara", userTest.getName());
    }

    @Test
    public void getLogTest() {
        assertEquals(log, userTest.getLog());
    }

}
