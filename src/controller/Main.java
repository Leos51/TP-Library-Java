package controller;

import utils.exception.SaisieException;

import static controller.BookController.seedBookData;
import static controller.LoanController.seedLoansData;
import static controller.SubscriberController.seedSubscriberData;
import static view.MainMenu.displayMainMenu;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Main m = new Main();
            m.run();
        }

        public void run() {
        seedSubscriberData();
        seedBookData();
        seedLoansData();
        displayMainMenu();
    }
}