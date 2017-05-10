package lab_2;

import Model.BookTable;
import Model.TableModel;
import lab_2.SearchAndDelStr.SearchBookRecord;
import Window.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class DelRecord {
    private JFrame frame;
    private Dialog dialog;
    private BookTable bookTable;
    private TableModel tableModel;


    public DelRecord(BookTable bookTable) {

        this.bookTable = bookTable;
        tableModel = bookTable.getTableModel();
        dialog = new Dialog("Удаление записи", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });

        frame = dialog.getFrame();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void deleteBook() {
        // if (!dialog.getLastName().equals("")) {
        /*if (bookTable != null)
            frame.remove(bookTable);*/
        List<BookInfo> searchBook = new SearchBookRecord(dialog.getInfoTabPane()).searchPatternSearchAbstrClass(tableModel.getBookInfo());
       // bookTable = new BookTable();
        tableModel.getBookInfo().removeAll(searchBook);
        //bookTable.getTableModel().getBookInfo().addAll(searchBook);
        bookTable.updateRecord();
        if (searchBook.size() > 0) {
            JOptionPane.showMessageDialog
                    (null, "Удалено " + searchBook.size() + " книг", "Информация", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog
                    (null, "Книга не найдена", "Внимание", JOptionPane.WARNING_MESSAGE);
        }
        //bookTable.setLocation(300,300);
       /* frame.add(bookTable,BorderLayout.NORTH);

        frame.setSize(new Dimension(850, 600));
        frame.revalidate();
        frame.repaint();*/

        /*} else {
            JOptionPane.showMessageDialog
                    (null, "Информация не корректна", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }*/
    }

    public JFrame getFrame() {

        return frame;
    }
}
