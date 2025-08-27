package view.swing.handmade.tabs;


import java.awt.*;
import javax.swing.*;

public class SubscriberPanel extends JPanel {
    public SubscriberPanel() {
        this.setLayout(new GridLayout(1,4));

        JButton displaySubscriberBtn = new JButton("Afficher les prets en cours");
        JButton addSubscriberBtn = new JButton("Emprunter un livre");
        JButton removeSubscriberBtn = new JButton("Retourner un livre");

        this.add(displaySubscriberBtn);
        this.add(addSubscriberBtn);
        this.add(removeSubscriberBtn);
    }
}
