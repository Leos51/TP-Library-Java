package test;

import model.book.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.exception.SaisieException;

import static org.junit.jupiter.api.Assertions.*;
import static utils.UserInput.capitalize;

class BookTest {

    Book book;

    @BeforeEach
    void setUp() {
        try {
            book = new Book("Clean Code", "Robert C. Martin","9780132350884",1);
        } catch (SaisieException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void tearDown() {
        book = null;
    }

    @Test
    public void testConstructeurArgsValide() throws Exception {
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals("9780132350884", book.getIsbn());
        assertEquals(1, book.getQuantity());
    }

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"Effective Java", " 1984", "LEOS ", "ça", "Ca"} )
    void setTitleTest_Success(String title) throws Exception {

        book.setTitle(title);
        // Assert
        assertEquals(title.trim(), book.getTitle());
    }

    @Test
    void testGetAuthor() {
        assertEquals("Robert C. Martin", book.getAuthor());
    }

    @Test
    void testSetAuthor() {
        try{ book.setAuthor("Joshua Bloch");
            assertEquals("Joshua Bloch", book.getAuthor());}
        catch (SaisieException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }


    @Test
    void testGetIsbn() {
        assertEquals("9780132350884", book.getIsbn());
    }

    @Test
    void testSetIsbn() {
        try{
            book.setIsbn("0185997054");
            assertEquals("0185997054", book.getIsbn());
        }catch (SaisieException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

    }

    @Test
    void testGetQuantity() {
        assertEquals(1, book.getQuantity());
    }

    @Test
    void testSetQuantity() {
        try {
            book.setQuantity(10);
            assertEquals(10, book.getQuantity());
        } catch (SaisieException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

    }

    @Test
    void testIsAvailable() {
        assertTrue(book.isAvailable());
    }

    @Test
    void testIsUnavailable() {
        try{
            book.decreaseStock();
            assertFalse(book.isAvailable());
        } catch (SaisieException e) {
            System.err.println("Erreur : " + e.getMessage());
        }

    }

    @Test
    void testDecreaseStock() {
        try {
            book.decreaseStock();
            assertEquals(0, book.getQuantity());
        }catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    void testIncreaseStock() {
        book.increaseStock();
        assertEquals(2, book.getQuantity());
    }

    @Test
    void testToString() {
        assertEquals("Clean Code - Robert C. Martin - 9780132350884", book.toString());
    }
}