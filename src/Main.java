import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MainJPanel {
    public MainJPanel() {
        JFrame frame = new JFrame("Вторая лабораторная");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
