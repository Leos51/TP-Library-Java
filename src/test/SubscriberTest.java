package test;

import controller.LoanController;
import model.user.Subscriber;
import model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DateFormat.format;

class SubscriberTest {

    Subscriber subscriber1;
    Subscriber subscriber2;

    @BeforeEach
    void setUp() {
        subscriber1 = new Subscriber("Leo", "Rain", "leo.rain@gmail.com");
        subscriber2 = new Subscriber("Recto", "Verso", "recto.verso@simplemail.com", LocalDate.now().plusDays(8));
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
    void testSetEmail() {
        subscriber1.setEmail("prenom.nom@live.fr");
        assertEquals("prenom.nom@live.fr", subscriber1.getEmail());
        assertNotEquals("leo.rain@gmail.com",  subscriber1.getEmail());
    }

    @Test
    void getRegistrationDate() {
        assertEquals(format(LocalDate.now()), subscriber1.getRegistrationDate());
        assertEquals(format(LocalDate.now().plusDays(8)), subscriber2.getRegistrationDate());
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