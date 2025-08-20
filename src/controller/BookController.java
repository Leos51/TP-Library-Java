package controller;

import model.book.Book;


import static model.lists.books.Books.books;
import static view.Menu.displayMenu;

public class BookController {

    public static void seedBookData() {
        books.add(new Book("1984", "George Orwell", "9780451524935"));
        books.add(new Book("Le Petit Prince", "Antoine de Saint-Exupéry", "9782070612758"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));
        books.add(new Book("L'Étranger", "Albert Camus", "9782070360024"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227"));
    }

    public static void displayBooks(){
        System.out.println("Liste des livres");
        System.out.println("----------------");
        for(Book book : books){
            System.out.println(book.toString());
        }
        displayMenu();
    }


}
