package test;

import model.book.Book;
import model.loan.Loan;
import model.user.Subscriber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    Subscriber subscriber;
    Subscriber user2;
    Book book;
    Loan loan;

    @BeforeEach
    void setUp() {
        subscriber = new Subscriber("prenom", "Nom", "email@email.fr");
        user2 = new Subscriber("leo", "Dupont", "leodupont@mail.com");
        book = new Book("Livre 1", "Auteur 1", "5154545045454545", 2);
        loan = new Loan(subscriber,book);

    }

    @AfterEach
    void tearDown() {
        subscriber = null;
        book = null;
        loan = null;
    }

    @Test
    void testGetLoanStartDate() {
        assertTrue(LocalDate.now().equals(loan.getLoanStartDate()));
    }

    @Test
    void testSetLoanStartDate() {
        loan.setLoanStartDate(LocalDate.now().minusDays(2));
        assertTrue(loan.getLoanStartDate().equals(LocalDate.now().minusDays(2)));
    }

    @Test
    void testGetLoanEndDate() {
        assertTrue(loan.getLoanEndDate().equals(LocalDate.now().plusDays(7)));
    }

    @Test
    void testSetLoanEndDate() {
        loan.setLoanEndDate(LocalDate.now().minusDays(2));
        assertTrue(loan.getLoanEndDate().equals(LocalDate.now().minusDays(2)));
    }

    @Test
    void testGetUser() {
        assertEquals("prenom", loan.getUser().getFirstName());
    }

    @Test
    void testSetUser() {

        loan.setUser(user2);
        assertTrue(loan.getUser().equals(user2));
    }

    @Test
    void testGetBook() {
        assertEquals("Livre 1", loan.getBook().getTitle());
        assertEquals("5154545045454545", loan.getBook().getIsbn());
        assertEquals("Auteur 1", loan.getBook().getAuthor());
        assertTrue(loan.getBook().getAuthor().equals(loan.getBook().getAuthor()));
    }

    @Test
    void testSetBook() {
        Book book2 = new Book("L'épée de Verité", "Martin GoodKind", "1234567891",5);
        loan.setBook(book2);
        assertTrue(loan.getBook().equals(book2));
        assertEquals("L'épée de Verité", loan.getBook().getTitle());
        assertEquals("Martin GoodKind", loan.getBook().getAuthor());
        assertEquals("1234567891", loan.getBook().getIsbn());


    }

    @Test
    void testToString() {
        String startDate = loan.getLoanStartDate().toString();
        String endDate = loan.getLoanEndDate().toString();
        assertEquals("Livre 1 - Debut du pret : " + startDate + " - Fin du pret : " + endDate, loan.toString());
    }
}