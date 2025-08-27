package view.swing.handmade.bookpanels;

import javax.swing.*;
import java.awt.*;

public class AddBookPanel extends JPanel {
    public AddBookPanel() {
        JLabel title = new JLabel("Title");
        JLabel author = new JLabel("Author");
        JLabel qty = new JLabel("Quantité");
        JLabel isbn = new JLabel("ISBN");

        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField qtyField = new JTextField();
        JTextField isbnField = new JTextField();


        JButton addBookButton = new JButton("Add Book");
        JButton cancelButton = new JButton("Cancel");
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.add(addBookButton);
        buttonsPanel.add(cancelButton);


        this.setLayout(new GridLayout(9,1));
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(title);
        this.add(titleField);
        this.add(author);
        this.add(authorField);
        this.add(qty);
        this.add(qtyField);
        this.add(isbn);
        this.add(isbnField);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(addBookButton);
        buttonGroup.add(cancelButton);

        this.add(buttonsPanel);




        addBookButton.addActionListener(e -> {

        });
    }
}
