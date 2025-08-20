package model.lists.loans;

import model.loan.Loan;

import java.util.ArrayList;
import java.util.List;

public class Loans {
    public static List<Loan> loans =  new ArrayList<Loan>();

    public void  addLoan(Loan loan){
        this.loans.add(loan);
    }
    public void removeLoan(Loan loan){
        this.loans.remove(loan);
    }

}
