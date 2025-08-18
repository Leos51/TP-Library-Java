package model.loan;

import model.book.Book;
import model.person.User;

import java.time.LocalDate;

public class Loan {
    LocalDate loanStartDate;
    LocalDate loanEndDate;
    User user;
    Book book;


    Loan(User user, Book book) {
        this.loanStartDate = LocalDate.now();
        this.loanEndDate = LocalDate.now();
        this.user = user;
        this.book = book;
    }
    Loan(User user, Book book,  LocalDate loanStartDate, LocalDate loanEndDate) {
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
