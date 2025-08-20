package model.lists.books;

import model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Books {
    public static List<Book> books = new ArrayList<>();


    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public void addBook(Book book){
        this.books.add(book);
    }

    public static Book findBookByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    return book;
                }
            }
            return null;
    }

    public static void removeBook(String title) {
        Book book = findBookByTitle(title);
        books.remove(book);
    }

}
