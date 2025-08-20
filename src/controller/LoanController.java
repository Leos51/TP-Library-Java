package controller;

import model.lists.books.Books;
import model.lists.users.Subscribers;
import model.loan.Loan;

import static model.lists.loans.Loans.loans;
import static view.Menu.displayMenu;

public class LoanController {

    public static void seedLoansData() {
        loans.add(
                new Loan(
                        Subscribers.findSubscriberByEmail("sophie.bernard@email.com"),
                        Books.findBookByTitle("The Hobbit")
                )
        );
    }

    public static void displayLoans(){
        System.out.println("Prêts en cours");
        System.out.println("----------------");
       for(Loan loan : loans){
           System.out.println(loan);
       }
        displayMenu();
    }
}
