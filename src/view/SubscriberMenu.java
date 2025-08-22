package view;

import controller.SubscriberController;
import model.lists.users.Subscribers;
import model.user.Subscriber;
import utils.UserInput;
import utils.validator.Validator;

import java.util.InputMismatchException;

import static view.MainMenu.displayMainMenu;

public class SubscriberMenu {
    public static void displaySubscriberMenu(){
        System.out.println("---------------");
        System.out.println("Onglet Abonné");
        System.out.println("---------------");
        System.out.println("1 - Afficher la liste des abonnés");
        System.out.println("2 - Enregistrer un nouvel abonné");
        System.out.println("0 - Retour");
        choiceSuscriberMenu();

    }

    public static void choiceSuscriberMenu(){
        int userChoice;
        int[] validChoices = {0, 1, 2};
        boolean valid = false;
        do{
            userChoice = UserInput.getIntValue("Votre Choix [1-2] ou [0] pour le menu principal : ");

            for(int validChoice : validChoices){
                if(userChoice == validChoice){
                    valid = true;
                    break;
                }
            }

            switch (userChoice) {
                case 1 -> SubscriberController.displaySubscribers();
                case 2 -> addSubscriberMenu();
                case 0 -> displayMainMenu();
                default -> System.err.println("Choix invalide.");
            }
        }while(!valid);

    }

    public static void addSubscriberMenu() {
        try{
            System.out.println("--------------");
            String firstName = UserInput.getStringValue("Prenom de l'abonné : ");
            if(!Validator.isValidName(firstName)){
                throw new InputMismatchException("Le prenom est invalide. (3 à 20 caracteres)");
            }
            String lastName = UserInput.getStringValue("Nom de l'abonné : ");
            if(!Validator.isValidName(lastName)){
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
            displaySubscriberMenu();
        }

    }
}
