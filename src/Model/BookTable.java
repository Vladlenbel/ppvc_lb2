package Model;

import javax.swing.*;
import java.awt.*;
import Window.*;

/**
 * Created by Vladlen on 09.05.2017.
 */
public class BookTable  extends JComponent {

    private BookInfo bookInfo;
    private TableModel tableModel;

    public BookTable(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        tableModel = new TableModel();
        makeTable();
    }

    private JTable makeTable(){
        JTable bookTable;/* = new JTable(1, 8);

        /*Object[] columnsHeaders = new String[]{"Название книги", "Имя автора", "Фамилия автора","Отчество автора","Издательство",
                "Число томов", "Тираж", "Итого томов"};

        for (int i = 0; i<8; i++) {
            bookTable.setValueAt(columnsHeaders[i], 0, i);
        }*/

        bookTable = visualBookInfoToList();

        return bookTable;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void updateRecord(){
        removeAll();
        makeTable();
        revalidate();
        repaint();
    }

    public JTable visualBookInfoToList(){
        int sizeList = tableModel.getBookInfo().size();

        JTable bookTable = new JTable(sizeList+1, 8);
        bookTable.setLayout(new GridBagLayout());
        add(bookTable);
        Object[] columnsHeaders = new String[]{"Название книги", "Имя автора", "Фамилия автора","Отчество автора","Издательство",
                "Число томов", "Тираж", "Итого томов"};

        for (int i = 0; i<8; i++) {
            bookTable.setValueAt(columnsHeaders[i], 0, i);
        }

        for (int indList = 0; indList < sizeList; indList++) {
            Object[] visual = new String[]{tableModel.getBookInfo().get(indList).getBookName(),
                    tableModel.getBookInfo().get(indList).getFirstName(),
                    tableModel.getBookInfo().get(indList).getLastName(),
                    tableModel.getBookInfo().get(indList).getFatherName(),
                    tableModel.getBookInfo().get(indList).getPublishingHouse(),
                    Integer.toString(tableModel.getBookInfo().get(indList).getNumberVolumes()),
                    Integer.toString(tableModel.getBookInfo().get(indList).getCirculation()),
                    Integer.toString(tableModel.getBookInfo().get(indList).getTotalVolumes())};

            for (int j = 0; j < 8; j++) {
                bookTable.setValueAt(visual[j], indList+1, j);
            }
            //frame.add(bookTable);
            //frame.setVisible(true);
        }
        return bookTable;
    }

}
