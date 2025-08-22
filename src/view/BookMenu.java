package view;

import controller.BookController;
import model.book.Book;
import model.lists.books.Books;
import utils.UserInput;
import utils.validator.Validator;


public class BookMenu {

    public static void displayBookMenu(){
        System.out.println("---------------");
        System.out.println("\uD83D\uDCD6 Onglet Livre");
        System.out.println("---------------");
        System.out.println("1 - Afficher la liste des livres");
        System.out.println("2 - Enregistrer un nouveau livre");
        System.out.println("3 - Modifier un livre existant (En construction)");
        System.out.println("4 - Supprimer un livre (En construction)");
        System.out.println("0 - Retour");
        choiceBookMenu();
    }
    public static void choiceBookMenu(){
        int userChoice;
        int[] validChoices = {0, 1, 2, 3, 4};
        boolean valid = false;
        do{
            userChoice = UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ");
            for(int validChoice : validChoices){
                if(userChoice == validChoice){
                    valid  = true;
                    break;
                }
            }
            switch (userChoice) {
                case 1 -> BookController.displayBooks();
                case 2 -> addBookMenu();
                case 3 -> updateBookMenu();
                case 4 -> {
                    System.out.println("Supprimer livre (En construction)");
                    displayBookMenu();
                }
                case 0 -> MainMenu.displayMainMenu();
                default -> System.err.println("Choix invalide.");
            }
        }while(!valid);
    }

    public static void addBookMenu(){
        try{        System.out.println("--------------");
            String title = UserInput.getStringValue("Titre du livre : ");
            if(!Validator.isValidBookTitle(title)){
                throw new IllegalArgumentException("Saisie titre incorrect");
            }
            String author = UserInput.getStringValue("Auteur du livre: ");
            String isbn = UserInput.getStringValue("isbn du livre: ");
            if(!Validator.isValidISBN(isbn)){
                throw new IllegalArgumentException("Saisie isbn incorrect");
            }
            int quantity = Integer.parseInt(UserInput.getStringValue("Quantite du livre : "));
            if(Validator.isValidPositiveInt(quantity)){
                throw new IllegalArgumentException("Quantite invalide.");
            }
            Books.addBook(new Book(title, author, isbn, quantity));
            if(Books.findBookByISBN(isbn) == null){
                throw new Exception("Erreur lors de l'ajout. Recommencer");
            }
            System.out.println("Le livre \"" + title + "\" a bien été ajouté.");
        }catch(Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }
        finally {
            displayBookMenu();
        }
    }

    static void updateBookMenu(){
        System.out.println("--------------");
        System.out.println("Quel livre voulez vous modifier?");
        String isbn = UserInput.getStringValue("ISBN du livre à modifier : ");
        Book book = Books.findBookByISBN(isbn);
        System.out.println("Quel entrée souhaitez vous modifier?");
        System.out.println("1 - Modifier le titre");
        System.out.println("2 - Modifier l'auteur");
        System.out.println("3 - Modifier la quantité");
        System.out.println("0 - Retour");

        int[] validChoices = {0, 1, 2, 3};
        boolean valid = false;
        int userChoice;



        do{
            userChoice = UserInput.getIntValue("Votre choix  : ");
            for(int validChoice : validChoices){
                if(userChoice == validChoice){
                    valid  = true;
                    break;
                }
            }
            switch(userChoice){
                case 1 -> book.setTitle(UserInput.getStringValue("Titre du livre : "));
                case 2  -> book.setAuthor(UserInput.getStringValue("Auteur du livre : "));
                case 3 -> book.setQuantity(UserInput.getIntValue("Quantite du livre : "));
                case 0 -> MainMenu.displayMainMenu();
                default -> System.err.println("Choix invalide.");
            }

        }while(!valid);






    }

}
