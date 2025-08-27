package view.swing.handmade.tabs;

import view.swing.handmade.MainFrame;
import view.swing.handmade.bookpanels.AddBookPanel;

import javax.swing.*;
import java.awt.*;

public class BookTab extends JPanel {
//    MainFrame mainFrame;


    public BookTab() {
        AddBookPanel addBookPanel = new AddBookPanel();
//        mainFrame.add(addBookPanel);

        JButton displayBookBtn = new JButton("Afficher la liste des livres");
        JButton addBookBtn = new JButton("Ajouter un livre");
        JButton editBookBtn = new JButton("Modifier un livre");

        this.add(displayBookBtn);
        this.add(addBookBtn);
        this.add(editBookBtn);

        this.setBackground(Color.lightGray);
        this.setLayout(new GridLayout(1,4));

        addBookBtn.addActionListener(e -> {
            displayBookBtn.setText("Text changé");
            addBookPanel.setVisible(true);
        });

        editBookBtn.addActionListener(e -> {
            editBookBtn.setText("XXXXXXXXX");
        });


    }

}
