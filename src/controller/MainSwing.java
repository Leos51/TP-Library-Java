package controller;

import view.swing.handmade.MainFrame;
import view.swing.uidesigner.MainFrameGUI;

import javax.swing.*;

public class MainSwing {

    public static void main(String[] args) {
        MainSwing main = new MainSwing();
        main.run();
    }
    private void run(){
//        initUI(); // crée manuellemnt


        initUI_Designer(); //Crée avec uidesigner

    }

    private void initUI(){
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }

    private void initUI_Designer(){
        SwingUtilities.invokeLater(() -> {
            MainFrameGUI mainFrameGUI = new MainFrameGUI();
            mainFrameGUI.setVisible(true);
        });
    }
}
