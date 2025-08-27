package model.book;

import utils.RegexPatterns;
import utils.exception.SaisieException;
import utils.validator.Validator;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;

    public Book() {

    }


    public Book(String title, String author, String isbn,  int quantity) throws SaisieException {
        this.setTitle(title);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setQuantity(quantity);

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws SaisieException {
        title = title.trim();
        if(title.isBlank() || title.length() < 2) {
            throw new SaisieException("Le titre doit faire plus de 2 caracteres");
        }
        if(!Validator.isValidBookTitle(title)) {
            throw new SaisieException("Le titre n'est pas valide");

        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws SaisieException {
        if(author.isBlank() || author.length() < 5) {
            throw new SaisieException("Le author doit faire plus de 5 caracteres");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws SaisieException {

        if(isbn == null) {
            throw new SaisieException("Le isbn ne doit pas etre null");
        }
        // test valeur vide
        if(isbn.isBlank() || isbn.isEmpty()) {
            throw new SaisieException("Le isbn doit faire plus de 5 caracteres");
        }
        if(isbn.length() < 10) {
            throw new SaisieException("Le isbn doit faire plus de 10 caracteres");
        }

        if(!Validator.isValidISBN(isbn)){
            throw new SaisieException("Le ISBN n'est pas valide");
        }
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) throws SaisieException {
        if(!Validator.isValidPositiveInt(quantity)){
            throw new SaisieException("La quantité n'est pas valide");
        }
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void decreaseStock() throws SaisieException {
        if(!isAvailable()) {
            throw new SaisieException("le livre n'est pas en stock");
        }
            quantity--;
    }

    public void increaseStock() {
        quantity++;
    }


    @Override
    public String toString(){
        return getTitle() + " - " + getAuthor() + " - " + getIsbn();
    }
}
