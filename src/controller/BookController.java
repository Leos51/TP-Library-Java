package controller;


import model.book.Book;
import model.lists.books.Books;
import view.Menu;


public class BookController {

    public static void seedBookData() {
        Books.addBook(new Book("1984", "George Orwell", "9780451524935" , 2));
        Books.addBook(new Book("Le Petit Prince", "Antoine de Saint-Exupéry", "9782070612758", 5));
        Books.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084", 1));
        Books.addBook(new Book("L'Étranger", "Albert Camus", "9782070360024", 1));
        Books.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227" ,1));
    }

    public static void displayBooks(){
        System.out.println("Liste des livres");
        System.out.println("----------------");
        for(Book book : Books.getBooks()){
            System.out.println(book.toString());
        }
        Menu.displayMainMenu();
    }


}
