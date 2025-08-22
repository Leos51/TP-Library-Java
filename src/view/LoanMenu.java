package view;

import controller.LoanController;
import model.book.Book;
import model.lists.books.Books;
import model.lists.loans.Loans;
import model.lists.users.Subscribers;
import model.loan.Loan;
import model.user.Subscriber;
import utils.UserInput;
import utils.validator.Validator;

import static view.MainMenu.displayMainMenu;

public class LoanMenu {

    public static void displayLoanMenu(){
        System.out.println("---------------");
        System.out.println("Onglet Pret");
        System.out.println("---------------");
        System.out.println("1 - Afficher les prêt en cours");
        System.out.println("2 - Enregistrer un nouvel emprunt");
        System.out.println("0 - Retour");
        choiceLoanMenu();
    }

    public static void choiceLoanMenu() {
        int[] validChoices = {0, 1, 2};
        int userChoice;
        boolean valid = false;
        do {
            userChoice = UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ");
            for (int validChoice : validChoices) {
                if (userChoice == validChoice) {
                    valid = true;
                    break;
                }
            }
            switch (userChoice) {
                case 1 -> LoanController.displayLoans();
                case 2 -> addLoanMenu();
                case 0 -> displayMainMenu();
                default ->  System.err.println("Choix invalide.");
            }
        } while (!valid);

    }

    public static void addLoanMenu(){
        try{
            System.out.println("--------------");
            String subscriberEmail = UserInput.getStringValue("Email : ");
            if(!Validator.isValidEmail(subscriberEmail)){
                throw new IllegalArgumentException("Saisie email incorrect");
            }
            Subscriber subscriber = Subscribers.findSubscriberByEmail(subscriberEmail);
            if(subscriber == null){
                throw new IllegalArgumentException("L'utilisateur n'existe pas. Faire l'enregistrement d'un nouvel abonné");
            }

            String isbn = UserInput.getStringValue("isbn du livre: ");
            if(!Validator.isValidISBN(isbn)){
                throw new IllegalArgumentException("Saisie isbn incorrect");
            }
            Book book = Books.findBookByISBN(isbn);
            if(book==null){
                throw new IllegalArgumentException("Le livre n'existe pas en BDD");
            }
            if(!book.isAvailable()){
                throw new IllegalArgumentException("Le livre n'est pas en stock");
            }
            Loans.addLoan(new Loan(subscriber, book));
            book.decreaseStock();
            System.out.println("L'emprunt du livre \"" + book.getTitle() + "\" a bien été enregistré.");
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }finally {
            displayLoanMenu();
        }
    }
}
