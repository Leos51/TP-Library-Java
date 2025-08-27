package model.loan;

import model.book.Book;
import model.user.Subscriber;
import utils.exception.SaisieException;

import java.time.LocalDate;

public class Loan {
    LocalDate loanStartDate;
    LocalDate loanEndDate;
    Subscriber subscriber;
    Book book;


    public Loan(Subscriber subscriber, Book book) {
        this.setLoanStartDate(LocalDate.now());
        this.setLoanEndDate(this.getLoanStartDate().plusDays(7));
        this.setUser(subscriber);
        this.setBook(book);
    }
    public Loan(Subscriber subscriber, Book book, LocalDate loanStartDate) {
        this.setLoanStartDate(loanStartDate);
        this.setLoanEndDate(this.getLoanStartDate().plusDays(7));
        this.setUser(subscriber);
        this.setBook(book);
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public LocalDate getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(LocalDate loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public Subscriber getUser() {
        return subscriber;
    }

    public void setUser(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        try{
            book.decreaseStock();
            this.book = book;
        }catch(SaisieException e){
            System.err.println("Saisie exception : " + e.getMessage());
        }

    }

    @Override
    public String toString() {
        return getBook().getTitle() + " - Debut du pret : " + getLoanStartDate() + " - Fin du pret : " + getLoanEndDate();
    }
}
