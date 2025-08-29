package view.swing.uidesigner.data_modele;

import model.book.Book;
import model.loan.Loan;
import model.user.Subscriber;

import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TableModele<T>  extends AbstractTableModel {

    private final List<T> data;
    private String[] columnNames;
    private final Class<?>[] columnClasses;
    private final DateTimeFormatter FORMATTER_DATE_FRENCH = DateTimeFormatter.ofPattern("dd-MM-yyyy");



    public TableModele(List<T> data, String[] columnNames, Class<?>[] columnClasses) {
        this.data = data;
        this.columnNames = columnNames;
        this.columnClasses = columnClasses;

    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T item = data.get(rowIndex);
        if(item instanceof Book book){
            return switch (columnIndex) {
                case 0 -> book.getTitle();
                case 1 -> book.getAuthor();
                case 2 -> book.getQuantity() + "";
                default -> null;
            };
        }
        if(item instanceof Subscriber subscriber){
            return switch (columnIndex){
                case 0 -> subscriber.getLastName();
                case 1 -> subscriber.getFirstName();
                case 2 -> subscriber.getEmail();
                case 3 -> subscriber.getRegistrationDate().formatted(FORMATTER_DATE_FRENCH);
                default -> null;
            };
        }
        if(item instanceof Loan loan){
            return switch (columnIndex){
                case 0 -> loan.getUser().getLastName();
                case 1 -> loan.getUser().getFirstName();
                case 2 -> loan.getUser().getEmail();
                case 3 -> loan.getBook().getTitle();
                case 4 -> loan.getBook().getIsbn();
                case 5 -> loan.getLoanStartDate().format(FORMATTER_DATE_FRENCH);
                case 6 -> loan.getLoanEndDate().format(FORMATTER_DATE_FRENCH);
                default -> null;
            };
        }

        return null;
    }
}
