package model.lists.loans;

import model.book.Book;
import model.loan.Loan;
import model.user.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Loans {
    public static List<Loan> loans =  new ArrayList<>();


    public static void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoan(Loan loan){
        this.loans.remove(loan);
    }

}
