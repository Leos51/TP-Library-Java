package test;

import model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User("Recto", "Verso");
    }

    @AfterEach
    void tearDown() {
        user = null;
    }



    @Test
    public void testConstructeurArgsValide() throws Exception {
        // Assert
        assertEquals("Recto", user.getFirstName());
        assertEquals("Verso", user.getLastName());

    }

    @Test
    public void testConstructeurArgsinvalide() throws Exception {

        assertNotEquals("Clark", user.getFirstName());
        assertNotEquals("Kent", user.getLastName());
    }

    @org.junit.jupiter.api.Test
    void testGetFirstName() {
        assertEquals("Recto", user.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void testSetFirstName() {
        user.setFirstName("Sam");
        assertEquals("Sam", user.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void testGetLastName() {
        assertEquals("Verso", user.getLastName());
    }

    @org.junit.jupiter.api.Test
    void testsetLastName() {
        user.setLastName("Fischer");
        assertEquals("Fischer", user.getLastName());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("Recto Verso", user.toString());
    }
}