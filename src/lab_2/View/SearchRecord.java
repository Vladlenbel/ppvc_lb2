package lab_2.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Model.TableModel;
import Model.BookInfo;
import lab_2.SearchAndDelStr.SearchBookRecord;


/**
 * Created by Vladlen on 11.04.2017.
 */
public class SearchRecord {
    private JFrame frame;
    private Dialog dialog;
    private BookTable bookTable;
    private TableModel tableModel;

    public SearchRecord(TableModel tableModel) {
        this.tableModel = tableModel;
        dialog = new Dialog("Поиск записи", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });

        frame = dialog.getFrame();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void searchBook() {

        // if (!dialog.getLastName().equals("")) {
        if (bookTable != null)
            frame.remove(bookTable);
        List<BookInfo> searchBook = new SearchBookRecord(dialog.getInfoTabPane()).searchPatternSearchAbstrClass(tableModel.getBookInfo());
        bookTable = new BookTable();
        bookTable.getTableModel().getBookInfo().addAll(searchBook);
        bookTable.updateRecord();
        //bookTable.setLocation(300,300);
        frame.add(bookTable, BorderLayout.NORTH);

        frame.setSize(new Dimension(850, 600));
        frame.revalidate();
        frame.repaint();

        /*} else {
            JOptionPane.showMessageDialog
                    (null, "Информация не корректна", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }*/
    }

    public JFrame getFrame() {

        return frame;
    }
}
