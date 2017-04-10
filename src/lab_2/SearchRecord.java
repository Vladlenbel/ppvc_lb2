package lab_2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class SearchRecord {
    private JFrame frame1;

    public SearchRecord() {
        frame1 = new JFrame("Добавить запись");
        final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        tabbedPane.add("Поиск по ФИО автора", new FindFioAuthr().getPanel());
        tabbedPane.add("Поиск по издательству и ФОИ автора", new FindPublHouseAndFio().getPanel());
        tabbedPane.add("Поиск по ФИО автора и числу томов", new FindFioAuthrAndNumberVolumes().getPanel());
        tabbedPane.add("Поиск по названию книги", new FindNameBook().getPanel());
        /*tabbedPane.add("Задание №5", new FifthTask().getPanel());*/


        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.add(tabbedPane);
        frame1.setPreferredSize(new Dimension(600, 300));
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);


    }

    public JFrame getPanel() {

        return frame1;
    }
}
