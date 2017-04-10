package lab_2;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MainJPanel {
    public MainJPanel() {
        final JFrame frame = new JFrame("Вторая лабораторная");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar  toolbar = new JToolBar();
        toolbar.setRollover(true);

        ImageIcon addRecord = new ImageIcon(".\\src\\View\\images\\add.png");
        JButton addBut = new JButton(addRecord);
        toolbar.add(addBut);

        addBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().add(new addRecord().getPanel());
            }
        });

        ImageIcon delRecord = new ImageIcon(".\\src\\View\\images\\delite.png");
        JButton delBut = new JButton(delRecord);
        toolbar.add(delBut);

        ImageIcon serchRecord = new ImageIcon(".\\src\\View\\images\\search.png");
        JButton searchBut = new JButton(serchRecord);
        toolbar.add(searchBut);


        ImageIcon saveFile = new ImageIcon(".\\src\\View\\images\\save.png");
        JButton saveBut = new JButton(saveFile);
        toolbar.add(saveBut);

        ImageIcon openFile = new ImageIcon(".\\src\\View\\images\\open.png");
        JButton openBut = new JButton(openFile);
        toolbar.add(openBut);

        toolbar.addSeparator();

        Container contentPane = frame.getContentPane();
        contentPane.add(toolbar, BorderLayout.NORTH);
       /* JTextArea textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        contentPane.add(pane, BorderLayout.CENTER);*/


        frame.setPreferredSize(new Dimension(700, 500));
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
