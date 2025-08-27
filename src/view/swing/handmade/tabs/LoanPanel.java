package view.swing.handmade.tabs;

import javax.swing.*;
import java.awt.*;

public class LoanPanel extends JPanel {


    public LoanPanel() {

        JButton displayLoanBtn = new JButton("Afficher les emprunts en cours");
        JButton newLoanBtn = new JButton("Nouvel emprunt");
        JButton returnLoanBtn = new JButton("Retour de livre emprunté");
        this.setLayout(new GridLayout(1,4));

        this.add(displayLoanBtn);
        this.add(newLoanBtn);
        this.add(returnLoanBtn);



    }
}
