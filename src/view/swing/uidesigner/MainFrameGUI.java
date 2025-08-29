package view.swing.uidesigner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrameGUI extends JFrame {
    private JPanel contentPane;
    private JTabbedPane tabs;
    private JPanel book;
    private JPanel loan;
    private JPanel subscriber;
    private JButton showSubscribersBtn;
    private JButton addSubscriberBtn;
    private JButton editSubscriberBtn;
    private JButton showBooksBtn;
    private JButton editBookBtn;
    private JButton addBookBtn;
    private JButton showLoansBtn;
    private JButton returnLoanBtn;
    private JButton addLoanBtn;
    private JPanel home;
    private JButton displayBookBtn;
    private JPanel mainBook;
    private JPanel bookMenuPanel;
    private JTable bookTable;
    private JPanel tableBookPanel;
    private JPanel addBookPanel;
    private JTextField bookTitleInput;
    private JTextField bookAuthorInput;
    private JTextField bookIsbnInput;
    private JTextField bookStockInput;
    private JButton submitAddBookBtn;
    private JButton cancelAddBookBtn;
    private JPanel addBookBtnGroup;
    private JButton displayLoanBtn;
    private JPanel loanMenuPanel;
    private JPanel mainLoan;
    private JPanel displayLoanPanel;
    private JPanel addLoanPanel;
    private JButton displaySubscribersBtn;
    private JButton addSubscribersBtn;
    private JPanel subscriberMenuPanel;
    private JPanel mainSubcriberPanel;
    private JPanel showSubscribersPanel;
    private JPanel addSubscriberPanel;
    private JPanel subscriberMainCard;
    private JTable subscribersTable;
    private JTable loanTable;
    private JTextField subcriberNameInput;
    private JTextField subscriberFirstnameInput;
    private JTextField subscriberEmailInput;
    private JButton submitAddSubscriber;
    private JPanel subscriberBtnGroup;
    private JButton cancelAddSubscriber;
    private JTextField EmailAddloanInput;
    private JTextField isbnAddLoanInput;
    private JButton submitAddLoanBtn;
    private JButton cancelAddLoanBtn;
    private JPanel btnGroupAddLoan;
    private JPanel mainPanel;
    private JPanel loanPanel;
    private JPanel subscriberPanel;
    private JLabel bookLabel;
    private JPanel bookPanel;


    public MainFrameGUI() {

        setTitle("La liste des livres");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();



        /* -------------BOOK------------- */

        displayBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard(mainBook, "displayBooksCard");
            }
        });
        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard(mainBook, "addBookCard");
            }
        });

        /* ----------SUBSCRIBER---------- */
        displaySubscribersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard(mainSubcriberPanel, "displaySubscribersCard");

            }
        });
        addSubscribersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard(mainSubcriberPanel, "addSubscriberCard");

            }
        });


        /* -------------LOAN------------- */
        displayLoanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard(mainLoan, "displayLoanCard");

            }
        });
        addLoanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCard(mainLoan, "addLoanCard");

            }
        });

    }




    private void showCard(JPanel parentPanel, String cardName){
        CardLayout cl = (CardLayout) parentPanel.getLayout();
        cl.show(parentPanel, cardName);
    }



}
