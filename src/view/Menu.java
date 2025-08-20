package view;

import controller.BookController;
import controller.LoanController;
import controller.SubscriberController;
import model.book.Book;
import model.lists.books.Books;
import model.lists.users.Subscribers;
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
        switch (UserInput.getIntValue("Votre Choix [1-6] ou [0] pour quitter : ")) {
            case 1 -> displaySuscriberMenu();
            case 2 -> displayBookMenu();
            case 3 -> displayLoanMenu();
            case 0 -> System.exit(0);
        }

    }

    public static void displaySuscriberMenu(){
        System.out.println("---------------");
        System.out.println("Onglet Abonné");
        System.out.println("---------------");
        System.out.println("1 - Afficher la liste des abonnés");
        System.out.println("2 - Enregistrer un nouvel abonné");
        System.out.println("0 - Retour");
    }

    public static void choiceSuscriberMenu(){
        switch (UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ")) {
            case 1 -> SubscriberController.displaySubscribers();
            case 2 -> addSuscriberMenu();
            case 0 -> choiceMainMenu();
        }
    }

    public static void displayBookMenu(){
        System.out.println("---------------");
        System.out.println("Onglet Livre");
        System.out.println("---------------");
        System.out.println("1 - Afficher la liste des livres");
        System.out.println("2 - Enregistrer un nouveau livre");
        System.out.println("0 - Retour");
    }
    public static void choiceBookMenu(){
        switch (UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ")) {
            case 1 -> BookController.displayBooks();
            case 2 -> addBookMenu();
            case 0 -> choiceMainMenu();
        }
    }

    public static void displayLoanMenu(){
        System.out.println("---------------");
        System.out.println("Onglet Pret");
        System.out.println("---------------");
        System.out.println("1 - Afficher les prêt en cours");
        System.out.println("2 - Enregistrer un nouvel emprunt");
        System.out.println("0 - Retour");
    }
    public static void choiceLoanMenu(){
        switch (UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ")) {
            case 1 -> LoanController.displayLoans();
            case 2 -> addLoanMenu();;
            case 0 -> choiceMainMenu();
        }
    }


    public static void addSuscriberMenu(){
        try{
            System.out.println("--------------");
            String firstName = UserInput.getStringValue("Prenom de l'abonné : ");
            String lastName = UserInput.getStringValue("Nom de l'abonné : ");
            String email = UserInput.getStringValue("Email : ");
            if(!Validator.isValidEmail(email)){
                throw new Exception("Saisie email incorrect");
            }


            Subscribers.subscribers.add(new Subscriber(firstName, lastName, email));
            System.out.println("L'utilisateur' \"" + firstName + " " + lastName + "\" a bien été ajouté.");
            displayMainMenu();
        }catch(Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }

    }

    public static void addLoanMenu(){
        System.out.println("--------------");
        String title = UserInput.getStringValue("Titre du livre : ");
        String author = UserInput.getStringValue("Auteur du livre: ");
        String isbn = UserInput.getStringValue("isbn du livre: ");
        displayMainMenu();
    }

    public static void addBookMenu(){
        System.out.println("--------------");
        String title = UserInput.getStringValue("Titre du livre : ");
        String author = UserInput.getStringValue("Auteur du livre: ");
        String isbn = UserInput.getStringValue("isbn du livre: ");
        Books.books.add(new Book(title, author, isbn));
        if(Books.findBookByTitle(title)!= null){
            System.out.println("Le livre \"" + title + "\" a bien été ajouté.");
        }else{
            System.err.println("Erreur d'ajout.");
        }
        displayMainMenu();
    }


}
