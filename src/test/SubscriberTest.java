package test;

import controller.LoanController;
import model.user.Subscriber;
import model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.exception.SaisieException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DateFormat.format;

class SubscriberTest {

    Subscriber subscriber1;
    Subscriber subscriber2;

    @BeforeEach
    void setUp() {
        try{
            subscriber1 = new Subscriber("Leo", "Rain", "leo.rain@gmail.com");
            subscriber2 = new Subscriber("Recto", "Verso", "recto.verso@simplemail.com", LocalDate.now().plusDays(8));
        } catch (SaisieException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterEach
    void tearDown() {
        subscriber1 = null;
        subscriber2 = null;
    }


    @Test
    void testGetEmail() {
        assertEquals("leo.rain@gmail.com", subscriber1.getEmail());
    }



    @Test
    void getRegistrationDate() {
        assertEquals(format(LocalDate.now()), subscriber1.getRegistrationDate());
        assertEquals(format(LocalDate.now().plusDays(8)), subscriber2.getRegistrationDate());
    }

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"leo@mail.com", " link103@live.fr", "reD51@orange.fr"} )
    void testSetEmail_Success(String email) {
        subscriber1.setEmail(email);
        assertEquals(email, subscriber1.getEmail());
    }


    @ParameterizedTest(name = "{0} : le setter leve une exception correctement")
    @ValueSource(strings = {"Verso", " 1link103@live.fr", "reD51@"} )
    void testSetEmail_Fail(String email) {
        assertThrows(Exception.class, () -> subscriber1.setEmail(email));

    }

    @Test
    void setRegistrationDate() {
        subscriber1.setRegistrationDate(LocalDate.now().plusDays(-5));
        assertEquals(format(LocalDate.now().plusDays(-5)), subscriber1.getRegistrationDate());
    }

    @Test
    void testToString() {
        assertEquals("Recto Verso - Date d'inscription: " + subscriber2.getRegistrationDate(), subscriber2.toString());
    }
}