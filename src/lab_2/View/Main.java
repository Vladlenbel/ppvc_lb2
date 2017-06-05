package lab_2.View;

import lab_2.SearchAndDelStr.FileWorker;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MainJPanel {
    // JFrame frame;
    private final BookTable bookTable;
    private Model.Model model;
    private FileWorker fileWorker;

    public MainJPanel() {
        JFrame frame = new JFrame("Вторая лабораторная");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Verdana", Font.ITALIC, 12);
        //fileMenu.setFont(font);


        bookTable = new BookTable();
        model = new Model.Model(bookTable.getTableModel());
        fileWorker = new FileWorker(model);
        frame.add(bookTable, BorderLayout.CENTER);


        JMenuBar menuBar = new JMenuBar();

        JMenu menuTable = new JMenu("Таблица");

        JMenuItem jmRadd = new JMenuItem("Добавить запись");
        JMenuItem jmRdel = new JMenuItem("Удавлить запись");
        JMenuItem jmRserch = new JMenuItem("Поиск записи");

        JMenuItem jmFirstP = new JMenuItem("Первая страница");
        jmFirstP.setFont(font);
        menuTable.add(jmFirstP);
        jmFirstP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.firstPage();
                bookTable.updateRecord();
            }
        });
        JMenuItem jmLastP = new JMenuItem("Поcледняя страница");
        jmLastP.setFont(font);
        menuTable.add(jmLastP);
        jmLastP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.lastPage();
                bookTable.updateRecord();
            }
        });
        JMenuItem jmNextP = new JMenuItem("Следующая страница");
        jmNextP.setFont(font);
        menuTable.add(jmNextP);
        jmNextP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.nextPage();
                bookTable.updateRecord();
            }
        });
        JMenuItem jmPrevP = new JMenuItem("Предыдущая страница");
        jmPrevP.setFont(font);
        menuTable.add(jmPrevP);
        jmPrevP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.prevPage();
                bookTable.updateRecord();
            }
        });

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
        size.setFont(font);


        JMenuItem fiveSize = new JMenuItem("5");
        fiveSize.setFont(font);
        size.add(fiveSize);
        fiveSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRecordOnPage(5);
                bookTable.updateRecord();
            }
        });


        JMenuItem tenSize = new JMenuItem("10");
        tenSize.setFont(font);
        size.add(tenSize);
        tenSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRecordOnPage(10);
                bookTable.updateRecord();
            }
        });

        JMenuItem fiftySize = new JMenuItem("50");
        fiftySize.setFont(font);
        size.add(fiftySize);
        fiftySize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRecordOnPage(50);
                bookTable.updateRecord();
            }
        });

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

        JToolBar toolbar = new JToolBar();
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
                new DelRecord(bookTable);
            }
        });
        jmRdel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DelRecord(bookTable);
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
        // saveItem.setFont(font);
        toolbar.add(saveBut);
        saveBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new SaveFileRecord(fileWorker);
                // fileWorker.saveFile.saveFile();
            }
        });
        saveBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser filiOpener = new JFileChooser();
                // int ret = filiOpener.showDialog(null, "Сохранить файл");
                // new SaveFileRecord(fileWorker);
                fileWorker.saveFile.saveFile();
            }
        });

       /* jmFsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveFileRecord(fileWorker);
            }
        });*/
        jmFsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileWorker.saveFile.saveFile();
                /*JFileChooser filiOpener = new JFileChooser();
                int ret = filiOpener.showDialog(null, "Сохранить файл");
                new SaveFileRecord(fileWorker);*/
            }
        });


        ImageIcon openFile = new ImageIcon(".\\src\\View\\images\\open.png");
        JButton openBut = new JButton(openFile);
        toolbar.add(openBut);
        openBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new OpenFileRecord(bookTable,fileWorker);
                fileWorker.openFile.openFile();
                bookTable.updateRecord();
            }
        });

        /*openBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser filiOpener = new JFileChooser();
                int ret = filiOpener.showDialog(null, "Открыть файл");
            }
        });
        jmFopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OpenFileRecord(bookTable,fileWorker);
            }
        });*/
        jmFopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*JFileChooser filiOpener = new JFileChooser();
                int ret = filiOpener.showDialog(null, "Открыть файл");*/
                fileWorker.openFile.openFile();
                bookTable.updateRecord();
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
        }*/

        frame.add(bookTable);
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
