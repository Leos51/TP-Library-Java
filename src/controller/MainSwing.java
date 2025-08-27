package controller;

import view.swing.handmade.MainFrame;

import javax.swing.*;

public class MainSwing {

    public static void main(String[] args) {
        MainSwing main = new MainSwing();
        main.run();
    }
    private void run(){
        initUI();

    }

    private void initUI(){
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
