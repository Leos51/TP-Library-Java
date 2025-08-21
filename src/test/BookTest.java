package test;

import model.book.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BookTest {

    Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Clean Code", "Robert C. Martin","9780132350884",1);
    }

    @AfterEach
    void tearDown() {
        book = null;
    }

    @Test
    void getTitle() {
        assertEquals("Clean Code", book.getTitle());
    }

    @Test
    void setTitle() {
        book.setTitle("Effective Java");
        assertEquals("Effective Java", book.getTitle());
    }

    @Test
    void testGetAuthor() {
        assertEquals("Robert C. Martin", book.getAuthor());
    }

    @Test
    void testSetAuthor() {
        book.setAuthor("Joshua Bloch");
        assertEquals("Joshua Bloch", book.getAuthor());
    }


    @Test
    void testGetIsbn() {
        assertEquals("9780132350884", book.getIsbn());
    }

    @Test
    void testSetIsbn() {
        book.setIsbn("0185997054");
        assertEquals("0185997054", book.getIsbn());
    }

    @Test
    void testGetQuantity() {
        assertEquals(1, book.getQuantity());
    }

    @Test
    void testSetQuantity() {
        book.setQuantity(10);
        assertEquals(10, book.getQuantity());
    }

    @Test
    void testIsAvailable() {
        assertTrue(book.isAvailable());
    }

    @Test
    void testIsUnavailable() {
        book.decreaseStock();
        assertFalse(book.isAvailable());
    }

    @Test
    void testDecreaseStock() {
        book.decreaseStock();
        assertEquals(0, book.getQuantity());
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