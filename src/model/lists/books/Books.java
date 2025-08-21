package model.lists.books;

import model.book.Book;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private static List<Book> books = new ArrayList<>();


    public static List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public static void addBook(Book book){
        books.add(book);
    }

    public static Book findBookByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    return book;
                }
            }
            return null;
    }

//    public static Book findBookByAuthor(String author) {
//        for (Book book : books) {
//            if (book.getAuthor().equals(author)) {
//                return book;//penser a creer une liste qui retournera la liste des livre du meme auteur
//            }
//        }
//        return null;
//    }

    public static Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

//    public static void removeBook(String isbn) {
//        Book book = findBookByISBN(isbn);
//        books.remove(book);
//    }

}
