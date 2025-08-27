package view.swing.uidesigner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameGUI {
    private JTabbedPane tabs;
    private JPanel book;
    private JPanel loan;
    private JPanel subscriber;
    private JButton afficherLaListeDesButton;
    private JButton ajouterUnLivreButton;
    private JButton modifierUnLivreButton;
    private JButton afficherLesLivresButton;
    private JButton modifierUnLivreButton1;
    private JButton ajouterUnLivreButton1;
    private JButton afficherLesPretEnButton;
    private JButton retourDePretButton;
    private JButton enregistrerUnPretButton;
    private JPanel contantPane;
    private JPanel mainPanel;
    private JLabel title;

    public MainFrameGUI() {
        ajouterUnLivreButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
            }
        });
        modifierUnLivreButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(true);
            }
        });
        afficherLesLivresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show();
            }
        });


    }
    public void show(){
        afficherLesLivresButton.setVisible(false);
    }
}
