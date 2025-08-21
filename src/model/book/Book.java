package model.book;

import model.loan.Loan;
import utils.validator.Validator;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;


    private enum stockStatus {
        IN_STOCK,
        OUT_STOCK
    }

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
        if(title.isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas etre vide");
        }
        if(!Validator.isValidString_min3_max20(title)) {
            throw new IllegalArgumentException("Titre invalide");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws IllegalArgumentException {
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
