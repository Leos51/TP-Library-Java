package model.loan;

import model.book.Book;
import model.user.Subscriber;

import java.time.LocalDate;

public class Loan {
    LocalDate loanStartDate;
    LocalDate loanEndDate;
    Subscriber subscriber;
    Book book;


    Loan(Subscriber subscriber, Book book) {
        this.loanStartDate = LocalDate.now();
        this.loanEndDate = LocalDate.now();
        this.subscriber = subscriber;
        this.book = book;
    }
    Loan(Subscriber subscriber, Book book, LocalDate loanStartDate, LocalDate loanEndDate) {
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.subscriber = subscriber;
        this.book = book;
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
        this.book = book;
    }
}
