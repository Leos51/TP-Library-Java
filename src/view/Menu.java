package view;

import controller.BookController;
import controller.LoanController;
import controller.SubscriberController;
import model.book.Book;
import model.lists.books.Books;
import model.lists.loans.Loans;
import model.lists.users.Subscribers;
import model.loan.Loan;
import model.user.Subscriber;
import utils.UserInput;
import utils.validator.Validator;

import java.util.InputMismatchException;

public class Menu  {

    public static void displayMainMenu() {
        System.out.println("----------------");
        System.out.println("| 2A Library |");
        System.out.println("----------------");
        System.out.println("1 - Onglet Abonnement");
        System.out.println("2 - Onglet Livres");
        System.out.println("3 - Onglet Emprunts");
        System.out.println("0 - Quitter");
        choiceMainMenu();
    }

    public static void choiceMainMenu(){
        int choice;
        int[] validChoices = {0, 1, 2, 3};
        do{
            choice = UserInput.getIntValue("Votre Choix [1-3] ou [0] pour quitter : ");
            if(choice < 0 || choice > validChoices.length){
                System.err.println("Choix invalide.");
            }
            switch (choice) {
                case 1 -> displaySuscriberMenu();
                case 2 -> displayBookMenu();
                case 3 -> displayLoanMenu();
                case 0 -> System.exit(0);
                default -> System.out.println("Choix invalide.");
            }
        }while(choice != 0 && choice != 1 && choice != 2 && choice != 3);
    }

    public static void displaySuscriberMenu(){
        System.out.println("---------------");
        System.out.println("Onglet Abonné");
        System.out.println("---------------");
        System.out.println("1 - Afficher la liste des abonnés");
        System.out.println("2 - Enregistrer un nouvel abonné");
        System.out.println("0 - Retour");
        choiceSuscriberMenu();

    }

    public static void choiceSuscriberMenu(){
        int choice;
        int[] validChoices = {0, 1, 2};
        do{
            choice = UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ");
            switch (choice) {
                case 1 -> SubscriberController.displaySubscribers();
                case 2 -> addSuscriberMenu();
                case 0 -> displayMainMenu();
                default -> System.err.println("Choix invalide.");
            }
        }while(choice != 0 && choice != 1 && choice != 2);

    }

    public static void displayBookMenu(){
        System.out.println("---------------");
        System.out.println("Onglet Livre");
        System.out.println("---------------");
        System.out.println("1 - Afficher la liste des livres");
        System.out.println("2 - Enregistrer un nouveau livre");
        System.out.println("0 - Retour");
        choiceBookMenu();
    }
    public static void choiceBookMenu(){
        int choice;
        int[] validChoices = {0, 1, 2};
        do{
            choice = UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ");
            switch (choice) {
                case 1 -> BookController.displayBooks();
                case 2 -> addBookMenu();
                case 0 -> displayMainMenu();
                default -> System.err.println("Choix invalide.");
            }
        }while(choice != 0 && choice != 1 && choice != 2);
    }

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
        int choice;
        do {
            choice = UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ");
            switch (choice) {
                case 1 -> LoanController.displayLoans();
                case 2 -> addLoanMenu();
                case 0 -> displayMainMenu();
                default ->  System.err.println("Choix invalide.");
            }
        } while (choice != 0 && choice != 1 && choice != 2);

    }


    public static void addSuscriberMenu() {
        try{
            System.out.println("--------------");
            String firstName = UserInput.getStringValue("Prenom de l'abonné : ");
            if(!Validator.isValidString_min3_max20(firstName)){
                throw new InputMismatchException("Le prenom est invalide. (3 à 20 caracteres)");
            }
            String lastName = UserInput.getStringValue("Nom de l'abonné : ");
            if(!Validator.isValidString_min3_max20(lastName)){
                throw new InputMismatchException("Le nom est invalide. (3 à 20 caracteres)");
            }
            String email = UserInput.getStringValue("Email : ");
            if(!Validator.isValidEmail(email)){
                throw new IllegalArgumentException("Saisie email incorrect");
            }
            Subscribers.addSubscriber(new Subscriber(firstName, lastName, email));
            System.out.println("L'utilisateur' \"" + firstName + " " + lastName + "\" a bien été ajouté.");
            displayMainMenu();
        }catch(Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }finally {
            displaySuscriberMenu();
        }

    }

    public static void addLoanMenu(){
        try{
            System.out.println("--------------");
            String subscriberEmail = UserInput.getStringValue("Email : ");
            Subscriber subscriber = Subscribers.findSubscriberByEmail(subscriberEmail);
            String isbn = UserInput.getStringValue("isbn du livre: ");
            Book book = Books.findBookByISBN(isbn);
            Loans.addLoan(new Loan(subscriber, book));
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }finally {
            displayLoanMenu();
        }
    }

    public static void addBookMenu(){
        try{        System.out.println("--------------");
            String title = UserInput.getStringValue("Titre du livre : ");
            String author = UserInput.getStringValue("Auteur du livre: ");
            String isbn = UserInput.getStringValue("isbn du livre: ");
            int quantity = Integer.parseInt(UserInput.getStringValue("Quantite du livre : "));
            Books.addBook(new Book(title, author, isbn, quantity));
            if(Books.findBookByISBN(isbn) == null){
                throw new Exception("Erreur d'ajout.");
            }
                System.out.println("Le livre \"" + title + "\" a bien été ajouté.");
            }catch(Exception e){
                System.err.println("Erreur : " + e.getMessage());
            }
            finally {
                displayBookMenu();
            }

    }


}
