package controller;

import model.lists.books.Books;
import model.lists.loans.Loans;
import model.lists.users.Subscribers;
import model.loan.Loan;
import view.Menu;



public class LoanController {

    public static void seedLoansData() {
        Loans.addLoan(
                new Loan(
                        Subscribers.findSubscriberByEmail("sophie.bernard@email.com"),
                        Books.findBookByTitle("The Hobbit")
                )
        );
    }

    public static void displayLoans(){
        System.out.println("Prêts en cours");
        System.out.println("----------------");
       for(Loan loan : Loans.getLoans()){
           System.out.println(loan);
       }
        Menu.displayMainMenu();
    }
}
