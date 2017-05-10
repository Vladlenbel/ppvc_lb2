package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;
import java.util.List;

import Window.*;

/**
 * Created by Vladlen on 09.05.2017.
 */
public class BookTable  extends JComponent {

    private BookInfo bookInfo;
    private TableModel tableModel;
    private JScrollPane scrollTable;

    public BookTable(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        tableModel = new TableModel();
        makeTable();
    }

    private void makeTable(){
        /*JTable bookTable;
        bookTable = visualBookInfoToList();*/

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(visualBookInfoToList(), BorderLayout.NORTH);
        scrollTable = new JScrollPane(tablePanel);
        scrollTable.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent evt) {
                updateScrollTable();
            }
        });
        add(scrollTable);
      //  add(makeToolsPanel());

       // return bookTable;
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
    private void updateScrollTable() {
        scrollTable.revalidate();
        scrollTable.repaint();
    }

  /*  private JToolBar makeToolsPanel() {

        JToolBar panel = new JToolBar();
        panel.add(AddComponent.makeButton(new JButton(), "first.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.firstPage();
                updateRecord();
            }
        }));

        panel.add(AddComponent.makeButton(new JButton(), "last.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.lastPage();
                updateRecord();
            }
        }));
        panel.add(AddComponent.makeButton(new JButton(), "prev.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.prevPage();
                updateRecord();
            }
        }));
        panel.add(AddComponent.makeButton(new JButton(), "next.png", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableModel.nextPage();
                updateRecord();
            }
        }));
        String[] studentsOnPage = {"5","10","50"};
        JComboBox sizeBox = new JComboBox(studentsOnPage);
        sizeBox.setSelectedIndex(Arrays.asList(studentsOnPage).indexOf(Integer.toString(tableModel.getBooksOnPage())));
        sizeBox.setMaximumSize(new Dimension(70,100));
        sizeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String change = (String) cb.getSelectedItem();
                int size=Integer.parseInt(change);
                tableModel.firstPage();
                tableModel.setBooksOnPage(size);
                updateRecord();
            }
        });

        panel.add(sizeBox);
        return panel;
    }
*/
}
