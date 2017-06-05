package lab_2.View;

import lab_2.SearchAndDelStr.SearchAbstrClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 10.05.2017.
 */
public class Dialog {
    private JFrame frame;
    private FindFioAuthr findFioAuthr;
    private FindPublHouseAndFio findPublHouseAndFio;
    private FindNameBook findNameBook;
    private FindFioAuthrAndNumberVolumes findFioAuthrAndNumberVolumes;
    private FindCircultation findCircultation;
    private FindTotalVolumes findTotalVolumes;
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);


    public Dialog(String titleName, ActionListener actionListener) {
        frame = new JFrame(titleName);
        // final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        findFioAuthr = new FindFioAuthr(actionListener);
        findPublHouseAndFio = new FindPublHouseAndFio(actionListener);
        findNameBook = new FindNameBook(actionListener);
        findFioAuthrAndNumberVolumes = new FindFioAuthrAndNumberVolumes(actionListener);
        findCircultation = new FindCircultation(actionListener);
        findTotalVolumes = new FindTotalVolumes(actionListener);

        tabbedPane.add("Поиск по ФИО автора", findFioAuthr.getPanel());
        tabbedPane.add("Поиск по издательству и ФИО автора", findPublHouseAndFio.getPanel());
        tabbedPane.add("Поиск по ФИО автора и числу томов", findFioAuthrAndNumberVolumes.getPanel());
        tabbedPane.add("Поиск по названию книги", findNameBook.getPanel());
        tabbedPane.add("Поиск по тиражу >/< заданной границы", findCircultation.getPanel());
        tabbedPane.add("Поиск по итоговому количеству томов >/< заданной границы", findTotalVolumes.getPanel());
        //tabbedPane.set

        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(tabbedPane);
        frame.setPreferredSize(new Dimension(850, 300));
        /*frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);*/

    }

    public JFrame getFrame() {
        return frame;
    }


    public SearchAbstrClass getInfoTabPane() {
        if (tabbedPane.getSelectedIndex() == 0) {
            return findFioAuthr.getSearchBook();
        }

        if (tabbedPane.getSelectedIndex() == 1) {
            return findPublHouseAndFio.getSearchBook();
        }
        if (tabbedPane.getSelectedIndex() == 2) {
            return findFioAuthrAndNumberVolumes.getSearchBook();
        }

        if (tabbedPane.getSelectedIndex() == 3) {
            return findNameBook.getSearchBook();
        }

        if (tabbedPane.getSelectedIndex() == 4) {
            return findCircultation.getSearchBook();
        }
        return findTotalVolumes.getSearchBook();
    }

   /* public String getBookName() {
        return bookName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    public String getFatherName() {
        return fatherName.getText();
    }

    public String getPublishingHouse() {
        return publishingHouse.getText();
    }

    public String getNumberVolumes() {
        return numberVolumes.getText();
    }

    public String getCirculation() {
        return circulation.getText();
    }

    public String getTotalVolumes() {
        return totalVolumes.getText();
    }*/

}
