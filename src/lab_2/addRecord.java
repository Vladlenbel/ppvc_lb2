package lab_2;
import javax.swing.*;
import java.awt.*;
/**
 * Created by Vladlen on 10.04.2017.
 */
public class addRecord {
    private JFrame frame1;

    public addRecord() {
        frame1 = new JFrame("Добавить запись");
        frame1.getContentPane().setLayout(new FlowLayout());
        frame1.setPreferredSize(new Dimension(370, 400));
        frame1.pack();
        frame1.setLocationRelativeTo(null);


        JTextField textNameBook = new JTextField(30);
        JTextField textFioAuthor = new JTextField(30);
        JTextField textPublishingHouse = new JTextField(30);
        JTextField textNumberVolumes = new JTextField(30);
        JTextField textCirculation = new JTextField(30);
        JTextField textTotalVolumes = new JTextField(30);
        JButton addBut = new JButton("Add");
        addBut.setPreferredSize(new Dimension(250,30));


        frame1.add( new JLabel("Название книги"));
        frame1.add(textNameBook);
        frame1.add( new JLabel("ФИО автора"));
        frame1.add(textFioAuthor);
        frame1.add( new JLabel("Издательство"));
        frame1.add(textPublishingHouse);
        frame1.add( new JLabel("Число томов"));
        frame1.add(textNumberVolumes);
        frame1.add( new JLabel("Тираж"));
        frame1.add(textCirculation);
        frame1.add( new JLabel("Итого томов"));
        frame1.add(textTotalVolumes);
        frame1.add(addBut);

        frame1.setVisible(true);
    }

    public JFrame getPanel() {

        return frame1;
    }
}
