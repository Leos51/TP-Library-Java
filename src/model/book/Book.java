package model.book;

import utils.validator.Validator;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;


    public Book(String title, String author, String isbn,  int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.isBlank() || title.length() < 5) {
            throw new IllegalArgumentException("Le titre doit faire plus de 5 caracteres");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author.isBlank() || author.length() < 5) {
            throw new IllegalArgumentException("Le author doit faire plus de 5 caracteres");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws IllegalArgumentException {

        if(isbn == null) {
            throw new NullPointerException("Le isbn ne doit pas etre null");
        }
        // test valeur vide
        if(isbn.isBlank() || isbn.isEmpty()) {
            throw new IllegalArgumentException("Le isbn doit faire plus de 5 caracteres");
        }
        if(isbn.length() < 10) {
            throw new IllegalArgumentException("Le isbn doit faire plus de 10 caracteres");
        }

        if(!Validator.isValidISBN(isbn)){
            throw new IllegalArgumentException("Le ISBN n'est pas valide");
        }
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) throws IllegalArgumentException {
        if(!Validator.isValidPositiveInt(quantity)){
            throw new IllegalArgumentException("La quantité n'est pas valide");
        }
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void decreaseStock() {
        if(!isAvailable()) {
            throw new IllegalArgumentException("le livre n'est pas en stock");
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
