package view.swing.uidesigner;

import model.book.Book;
import model.lists.books.Books;
import model.lists.loans.Loans;
import model.lists.users.Subscribers;
import model.loan.Loan;
import model.user.Subscriber;
import view.swing.uidesigner.data_modele.TableModele;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DisplayList extends JPanel {
    private final DateTimeFormatter FORMATTER_DATE_FRENCH = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private JPanel panel1;
    private JPanel panelTable;
    private JPanel btnGroupTable;
    private JTable table;
    private JLabel tableTitle;
    private JButton backButton;
    private JScrollPane ScrollPaneTable;

    private final String[] HEADER_BOOK = new String[] {"Titre", "Auteur", "isbn", "Stock"};
    private final String[] HEADER_LOAN = new String[] {"Nom abonné", "Prénom abonné", "Email abonné", "titre du livre", "ISBN", "Debut pret", "Fin pret"};
    private final String[] HEADER_SUBSCRIBER = new String[] {"Nom", "Prenom", "Email", "Date d'inscription"};


    public DisplayList(int type) {

        switch (type) {
            case 0:
                tableTitle.setText("Listes de livres");
                buildDataTable(Books.getBooks(), HEADER_BOOK);
                break;
            case 1:
                tableTitle.setText("Listes des abonnés");
                buildDataTable(Subscribers.getSubscribers(), HEADER_SUBSCRIBER);

                break;
            case 2:
                tableTitle.setText("Emprunts en cours");
                buildDataTable(Loans.getLoans(), HEADER_LOAN);
                break;
            default:
                break;
        }

    }

    private <T> void configureTable(List<T> dataList, String[] headers, Class<?>[] columnClasses) {
        TableModel model = new TableModele(dataList, headers, columnClasses);
        this.table.setModel(model);
        this.table.revalidate();
        this.table.repaint();
    }

    private <T> void buildDataTable(List<T> dataList, String[] headers) {
        String[][] data = new String[dataList.size()][headers.length];

        for (int i = 0; i < dataList.size(); i++) {
            Object obj = dataList.get(i);
            if (obj instanceof Book) {
                Book book = (Book) obj;
                data[i][0] = book.getTitle();
                data[i][1] = book.getAuthor();
                data[i][2] = book.getIsbn();
                data[i][3] = book.getQuantity() + "";
            }else if (obj instanceof Subscriber) {
                Subscriber subscriber = (Subscriber) obj;
                data[i][0] = subscriber.getLastName();
                data[i][1] = subscriber.getFirstName();
                data[i][2] = subscriber.getEmail();
                data[i][3] = subscriber.getRegistrationDate();
            }else if (obj instanceof Loan) {
                Loan loan = (Loan) obj;
                data[i][0] = loan.getUser().getLastName();
                data[i][1] = loan.getUser().getFirstName();
                data[i][2] = loan.getUser().getEmail();
                data[i][3] = loan.getBook().getTitle();
                data[i][4] = loan.getLoanStartDate().format(FORMATTER_DATE_FRENCH);
                data[i][5] = loan.getLoanEndDate().format(FORMATTER_DATE_FRENCH);

            }
        }

        table = new JTable(data, headers);
        // ajout de la table dans le scrollpane
        ScrollPaneTable.setViewportView(table);
        // on redefinie le panelTable avec les modifications
        panelTable.revalidate();
        panelTable.repaint();
    };
}


