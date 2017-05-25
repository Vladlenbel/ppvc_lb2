package lab_2;

import Model.BookInfo;
import Model.BookTable;
import Model.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class addRecord {

    private final JTextField textNameBook = new JTextField(30);
    private final JTextField textFirstNameAuthor = new JTextField(30);
    private final JTextField textLastNameAuthor = new JTextField(30);
    private final JTextField textSurNameAuthor = new JTextField(30);
    private final JTextField textPublishingHouse = new JTextField(30);
    private final JTextField textNumberVolumes = new JTextField(30);
    private final JTextField textCirculation = new JTextField(30);
    private final JTextField textTotalVolumes = new JTextField(30);
    private JFrame frameAdd;
    private BookTable bookTable;
    private TableModel tableModel;
    private JButton addBut = new JButton("Добавить");


    public addRecord(BookTable mainTable) {

        this.bookTable = mainTable;
        tableModel = mainTable.getTableModel();
        createAddDialog();
        frameAdd.setVisible(true);
    }

    private JFrame createAddDialog() {
        frameAdd = new JFrame("Добавить запись");
        frameAdd.getContentPane().setLayout(new FlowLayout());
        frameAdd.setPreferredSize(new Dimension(370, 450));
        frameAdd.pack();
        frameAdd.setLocationRelativeTo(null);


       /* final JTextField textNameBook = new JTextField(30);
        final JTextField textFirstNameAuthor = new JTextField(30);
        final JTextField textLastNameAuthor = new JTextField(30);
        final JTextField textSurNameAuthor = new JTextField(30);
        final JTextField textPublishingHouse = new JTextField(30);
        final JTextField textNumberVolumes = new JTextField(30);
        final JTextField textCirculation = new JTextField(30);
        final JTextField textTotalVolumes = new JTextField(30);*/

        addBut.setPreferredSize(new Dimension(250, 30));


        frameAdd.add(new JLabel("Название книги"));
        frameAdd.add(textNameBook);
        frameAdd.add(new JLabel("Имя автора"));
        frameAdd.add(textFirstNameAuthor);
        frameAdd.add(new JLabel("Фамилия автора"));
        frameAdd.add(textLastNameAuthor);
        frameAdd.add(new JLabel("Отчество автора"));
        frameAdd.add(textSurNameAuthor);
        frameAdd.add(new JLabel("Издательство"));
        frameAdd.add(textPublishingHouse);
        frameAdd.add(new JLabel("Число томов"));
        frameAdd.add(textNumberVolumes);
        frameAdd.add(new JLabel("Тираж"));
        frameAdd.add(textCirculation);
        frameAdd.add(new JLabel("Итого томов"));
        frameAdd.add(textTotalVolumes);
        frameAdd.add(addBut);

        addBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewrecord();
            }
        });


        return frameAdd;
    }

    private void createNewrecord() {

        if (isRecordCorrect()) {
            //JOptionPane.showMessageDialog(null, textNameBook.getText());
            BookInfo bookInfo = new BookInfo(
                    textNameBook.getText(),
                    textFirstNameAuthor.getText(),
                    textLastNameAuthor.getText(),
                    textSurNameAuthor.getText(),
                    textPublishingHouse.getText(),
                    Integer.parseInt(textNumberVolumes.getText()),
                    Integer.parseInt(textCirculation.getText()),
                    Integer.parseInt(textTotalVolumes.getText()));

            tableModel.getBookInfo().add(bookInfo);

            bookTable.updateRecord();

        } else {
            JOptionPane.showMessageDialog(null, "Проверьте введенные данные!");
        }

                   /* Model.BookInfo bookInfo = new Model.BookInfo(textNameBook.getText(), textFirstNameAuthor.getText(),
                            textLastNameAuthor.getText(), textSurNameAuthor.getText(),
                            textPublishingHouse.getText(), Integer.parseInt(textNumberVolumes.getText()),
                            Integer.parseInt(textCirculation.getText()), Integer.parseInt(textTotalVolumes.getText()));*/

        //bookIntoList.add(bookInfo);
        //visualBookInfoToList();

                /*}
                frameAdd.dispose();*/


    }

    private boolean isRecordCorrect() {
        if (textNameBook.getText().length() == 0 || textFirstNameAuthor.getText().length() == 0
                || textLastNameAuthor.getText().length() == 0 || textSurNameAuthor.getText().length() == 0
                || textPublishingHouse.getText().length() == 0 || textNumberVolumes.getText().length() == 0
                || textCirculation.getText().length() == 0 || textTotalVolumes.getText().length() == 0) {
            return false;
            //JOptionPane.showMessageDialog(null, "Проверьте введенные данные!");
        }


        return true;


    }

    public JFrame getFrame() {

        return frameAdd;
    }

  /*  public void visualBookInfoToList(){
        int sizeList = Global.bookIntoList.bookInfoList.size();
        JTable bookTable = new JTable(sizeList+1, 8);
        Object[] columnsHeaders = new String[]{"Название книги", "Имя автора", "Фамилия автора","Отчество автора","Издательство",
                "Число томов", "Тираж", "Итого томов"};

        for (int i = 0; i<8; i++) {
            bookTable.setValueAt(columnsHeaders[i], 0, i);
        }

        for (int indList = 0; indList < sizeList; indList++) {
            Object[] visual = new String[]{Global.bookIntoList.get(indList).nameBook, Global.bookIntoList.get(indList).firstNameAuthor,
                    Global.bookIntoList.get(indList).lastNameAuthor, Global.bookIntoList.get(indList).surNameAuthor,
                    Global.bookIntoList.get(indList).publishingHouse, Integer.toString(Global.bookIntoList.get(indList).numberVolumes),
                    Integer.toString(Global.bookIntoList.get(indList).circulation), Integer.toString(Global.bookIntoList.get(indList).totalVolumes)};

            for (int j = 0; j < 8; j++) {
                bookTable.setValueAt(visual[j], indList+1, j);
            }
            Global.frame.add(bookTable);
            Global.frame.setVisible(true);
        }
    }*/
}




