package test;

import model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static utils.UserInput.capitalize;

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

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"Verso", "verso", "VERSO ", " verSo", "Heat",} )
    void setFirstNameTest_Success(String name) throws Exception {
        user.setFirstName(name);
        assertEquals(capitalize(name.trim()), user.getFirstName());
    }

    @ParameterizedTest(name = "{0} : le setter leve une exception correctement")
    @ValueSource(strings = {"1verso", "verso1", "123", "verso recto", "", "  123", "Yu", "  ",  "-_%" } )
    void setFirstNameTest_Fail(String name) throws Exception {
        assertThrows(Exception.class, () -> user.setFirstName(name));
    }

    @Test
    void testGetFirstName() {
        assertEquals("Recto", user.getFirstName());
    }

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"Verso", "verso", "VERSO ", " verSo", "Heat",} )
    void setLastNameTest_Success(String lastName) throws Exception {
        user.setLastName(lastName);
        assertEquals(capitalize(lastName.trim()), user.getLastName());
    }

    @ParameterizedTest(name = "{0} : le setter leve une exception correctement")
    @ValueSource(strings = {"1verso", "verso1", "123", "verso recto", "", "  123", "Yu", "  ",  "-_%", "azertyuiopqsdfdklmwfg" } )
    void setlastNameTest_Fail(String lastName) throws Exception {
        // Act + Assert
        assertThrows(Exception.class, () -> user.setLastName(lastName));
    }


    @Test
    void testGetLastName() {
        assertEquals("Verso", user.getLastName());
    }

    @Test
    void testsetLastName() {
        user.setLastName("Fischer");
        assertEquals("Fischer", user.getLastName());
    }

    @Test
    void testToString() {
        assertEquals("Recto Verso", user.toString());
    }
}