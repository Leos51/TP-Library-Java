package view;

import utils.UserInput;

import static view.BookMenu.displayBookMenu;
import static view.LoanMenu.displayLoanMenu;
import static view.SubscriberMenu.displaySubscriberMenu;

public class MainMenu {
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
        int[] validChoices = {0, 1, 2, 3};
        boolean valid = false;
        int userChoice;
        do{
            userChoice = UserInput.getIntValue("Votre Choix [1-3] ou [0] pour quitter : ");

            for(int validChoice : validChoices){
                if(userChoice == validChoice){
                    valid = true;
                    break;
                }
            }

            switch (userChoice) {
                case 1 -> displaySubscriberMenu();
                case 2 -> displayBookMenu();
                case 3 -> displayLoanMenu();
                case 0 -> exitApp();
                default -> System.err.println("Choix invalide.");
            }
        }while(!valid);
    }

    private static void exitApp() {
        System.out.println("Au revoir");
        System.exit(0);
    }

}
