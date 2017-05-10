package Window;

import Model.BookTable;
import lab_2.DelRecord;
import lab_2.SearchRecord;
import lab_2.addRecord;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class MainJPanel {
    // JFrame frame;
    private final BookTable bookTable;
    private Model model;
    public MainJPanel() {
        JFrame frame = new JFrame("Вторая лабораторная");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        bookTable = new BookTable();
        model=new Model(bookTable.getTableModel());
        frame.add(bookTable, BorderLayout.CENTER);


        JMenuBar  menuBar = new JMenuBar();

        JMenu menuTable = new JMenu("Таблица");

        JMenuItem jmRadd = new JMenuItem("Добавить запись");
        JMenuItem jmRdel = new JMenuItem("Удавлить запись");
        JMenuItem jmRserch = new JMenuItem("Поиск записи");

        JMenuItem jmFirstP = new JMenuItem("Первая страница");
        JMenuItem jmLastP = new JMenuItem("Поcледняя страница");
        JMenuItem jmNextP = new JMenuItem("Следующая страница");
        JMenuItem jmPrevP = new JMenuItem("Предведущая страниц");

        menuBar.add(menuTable);
        menuTable.add(jmRadd);
        menuTable.add(jmRdel);
        menuTable.add(jmRserch);

        menuTable.add(jmFirstP);
        menuTable.add(jmLastP);
        menuTable.add(jmNextP);
        menuTable.add(jmPrevP);

        JMenu size = new JMenu("Студентов на странице");
        menuTable.add(size);


        JMenuItem fiveSize = new JMenuItem("5");

        JMenuItem tenSize = new JMenuItem("10");

        JMenuItem fiftySize = new JMenuItem("50");

        size.add(fiveSize);
        size.add(tenSize);
        size.add(fiftySize);

        JMenu menuFile = new JMenu("Файл");

        JMenuItem jmFopen = new JMenuItem("Открыть файл");
        JMenuItem jmFsave = new JMenuItem("Сохранить файл");

        menuBar.add(menuFile);
        menuFile.add(jmFopen);
        menuFile.add(jmFsave);



        frame.setJMenuBar(menuBar);

        JToolBar  toolbar = new JToolBar();
        toolbar.setRollover(true);

        ImageIcon addRecord = new ImageIcon(".\\src\\View\\images\\add.png");
        JButton addBut = new JButton(addRecord);
        toolbar.add(addBut);

        addBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addRecord(bookTable);
        }
        });
        jmRadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addRecord(bookTable);
            }
        });

        ImageIcon delRecord = new ImageIcon(".\\src\\View\\images\\delete.png");
        JButton delBut = new JButton(delRecord);
        toolbar.add(delBut);

        delBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DelRecord();
            }
        });
        jmRdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DelRecord();
            }
        });

        ImageIcon serchRecord = new ImageIcon(".\\src\\View\\images\\search.png");
        JButton searchBut = new JButton(serchRecord);
        toolbar.add(searchBut);

        searchBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRecord(model.getTableModel());
            }
        });
        jmRserch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRecord(model.getTableModel());
            }
        });


        ImageIcon saveFile = new ImageIcon(".\\src\\View\\images\\save.png");
        JButton saveBut = new JButton(saveFile);
        toolbar.add(saveBut);

        ImageIcon openFile = new ImageIcon(".\\src\\View\\images\\open.png");
        JButton openBut = new JButton(openFile);
        toolbar.add(openBut);

        openBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser filiOpener = new JFileChooser();
                int ret = filiOpener.showDialog(null, "Открыть файл");
            }
        });

        toolbar.addSeparator();

        Container contentPane = frame.getContentPane();
        contentPane.add(toolbar, BorderLayout.NORTH);
       /* JTextArea textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        contentPane.add(pane, BorderLayout.CENTER);*/


        /*JTable bookTable = new JTable(1, 8);
        Object[] columnsHeaders = new String[]{"Название книги", "Имя автора", "Фамилия автора","Отчество автора","Издательство",
                "Число томов", "Тираж", "Итого томов"};

        for (int i = 0; i<8; i++) {
            bookTable.setValueAt(columnsHeaders[i], 0, i);
        }

        frame.add(bookTable);*/
        frame.setPreferredSize(new Dimension(900, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }



}

public class Main {

    public static void main(String[] args) {
        new MainJPanel();
    }
}
