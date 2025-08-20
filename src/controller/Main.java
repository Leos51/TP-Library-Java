package controller;

import static controller.BookController.seedBookData;
import static controller.LoanController.seedLoansData;
import static controller.SubscriberController.seedSubscriberData;
import static view.Menu.displayMainMenu;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Main m = new Main();
            m.run();
        }

        public void run(){
        seedSubscriberData();
        seedBookData();
        seedLoansData();
        displayMainMenu();
    }
}