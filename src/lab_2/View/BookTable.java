package lab_2.View;

import Model.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;
import java.util.List;

//import Window.*;

/**
 * Created by Vladlen on 09.05.2017.
 */
public class BookTable extends JComponent {


    private TableModel tableModel;
    private JScrollPane scrollTable;

    public BookTable() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        tableModel = new TableModel();
        makeTable();
    }

    private void makeTable() {
        JPanel tablePanel = new JPanel();
        JTable bookTabless = new JTable(1, 1);
        int sizeList = tableModel.getBookInfo().size();

        int recOnPage;
        if (tableModel.getNumberMaxPage() > tableModel.getThisPage()) {
            recOnPage = tableModel.getRecordOnPage();
        } else {
            recOnPage = sizeList - (tableModel.getNumberMaxPage() - 1) * tableModel.getRecordOnPage();
        }


        Object recordInfos = new String("Страница:" + Integer.toString(tableModel.getThisPage()) + "/" +
                Integer.toString(tableModel.getNumberMaxPage()) +
                " Книг на странице:" + Integer.toString(recOnPage) + " Всего книг:" + Integer.toString(sizeList)
        );
        bookTabless.setValueAt(recordInfos, 0, 0);


        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(bookTabless, BorderLayout.SOUTH);


        tablePanel.add(visualBookInfoToList(), BorderLayout.NORTH);


        scrollTable = new JScrollPane(tablePanel);
        scrollTable.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent evt) {
                updateScrollTable();
            }
        });
        add(scrollTable);
        add(pageList());


    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void updateRecord() {
        removeAll();
        makeTable();
        revalidate();
        repaint();
    }

    public JTable visualBookInfoToList() {

        int sizeList = tableModel.getBookInfo().size();
        int thisPage = tableModel.getThisPage();
        int recOnPage;
        // = tableModel.getRecordOnPage();;


        if (tableModel.getNumberMaxPage() > thisPage) {
            recOnPage = tableModel.getRecordOnPage();
        } else {
            recOnPage = sizeList - (tableModel.getNumberMaxPage() - 1) * tableModel.getRecordOnPage();
        }


        JTable bookTable = new JTable(recOnPage + 1, 8);
        bookTable.setLayout(new GridBagLayout());
        add(bookTable);
        Object[] columnsHeaders = new String[]{"Название книги", "Имя автора", "Фамилия автора", "Отчество автора", "Издательство",
                "Число томов", "Тираж", "Итого томов"};

        for (int i = 0; i < 8; i++) {
            bookTable.setValueAt(columnsHeaders[i], 0, i);
        }


        int indList;
        int endIndList = recOnPage + (thisPage - 1) * recOnPage;
        if (endIndList > sizeList) {
            endIndList = sizeList;
        }


        for (indList = (thisPage - 1) * recOnPage; indList < endIndList; indList++) {
            Object[] visual = new String[]{tableModel.getBookInfo().get(indList).getBookName(),
                    tableModel.getBookInfo().get(indList).getFirstName(),
                    tableModel.getBookInfo().get(indList).getLastName(),
                    tableModel.getBookInfo().get(indList).getFatherName(),
                    tableModel.getBookInfo().get(indList).getPublishingHouse(),
                    Integer.toString(tableModel.getBookInfo().get(indList).getNumberVolumes()),
                    Integer.toString(tableModel.getBookInfo().get(indList).getCirculation()),
                    Integer.toString(tableModel.getBookInfo().get(indList).getTotalVolumes())};

            for (int j = 0; j < 8; j++) {
                bookTable.setValueAt(visual[j], indList - (thisPage - 1) * recOnPage + 1, j);
            }

        }


        return bookTable;
    }

    private void updateScrollTable() {
        scrollTable.revalidate();
        scrollTable.repaint();
    }

    private JToolBar pageList() {

        JToolBar pageList = new JToolBar();
        pageList.setRollover(true);

        ImageIcon firstP = new ImageIcon(".\\src\\View\\images\\first.png");
        JButton firstPage = new JButton(firstP);
        pageList.add(firstPage);

        firstPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.firstPage();
                updateRecord();
            }
        });

        ImageIcon lastP = new ImageIcon(".\\src\\View\\images\\last.png");
        JButton lastPage = new JButton(lastP);
        pageList.add(lastPage);

        lastPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.lastPage();
                updateRecord();
            }
        });

        ImageIcon prevP = new ImageIcon(".\\src\\View\\images\\prev.png");
        JButton prevPage = new JButton(prevP);
        pageList.add(prevPage);

        prevPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.prevPage();
                updateRecord();
            }
        });

        ImageIcon nextP = new ImageIcon(".\\src\\View\\images\\next.png");
        JButton nextPage = new JButton(nextP);
        pageList.add(nextPage);

        nextPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.nextPage();
                updateRecord();
            }
        });


        String[] studentsOnPage = {"5", "10", "50"};
        JComboBox sizeBox = new JComboBox(studentsOnPage);
        sizeBox.setSelectedIndex(Arrays.asList(studentsOnPage).indexOf(Integer.toString(tableModel.getRecordOnPage())));
        sizeBox.setMaximumSize(new Dimension(70, 100));
        sizeBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String change = (String) cb.getSelectedItem();
                int size = Integer.parseInt(change);
                tableModel.firstPage();
                tableModel.setRecordOnPage(size);
                updateRecord();
            }
        });

        pageList.add(sizeBox);
        return pageList;
    }


}
