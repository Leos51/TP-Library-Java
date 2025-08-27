package view.swing.handmade;

import view.swing.handmade.bookpanels.AddBookPanel;
import view.swing.handmade.tabs.BookTab;
import view.swing.handmade.tabs.LoanPanel;
import view.swing.handmade.tabs.SubscriberPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame() {

        this.setTitle("Gestionnaire de bibliotheques");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        JLabel titleLabel = new JLabel("Bibliotheques");
        this.add(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);


//        AddBookPanel addBookPanel = new AddBookPanel();
//        this.add(addBookPanel);


        JPanel tabsPanel = new JPanel();
        BookTab bookTab = new BookTab();
        JPanel loanPanel = new LoanPanel();
        JPanel subscriberPanel = new SubscriberPanel();

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Bibliotheque", bookTab);
        tabs.add("Emprunt", loanPanel);
        tabs.add("Abonnement", subscriberPanel);

        tabsPanel.setLayout(new BorderLayout());
        tabsPanel.add(tabs, BorderLayout.SOUTH);
        this.add(tabsPanel,  BorderLayout.SOUTH);

    }
}
