package lab_2;
import javax.swing.*;
import java.awt.*;
/**
 * Created by Vladlen on 10.04.2017.
 */
public class addRecord {
    private JPanel panel;

    public addRecord() {
        panel = new JPanel();
        /*final JComboBox combo1 = new JComboBox();
        final JTextField textForCombo1 = new JTextField(10);
        JButton AddButton = new JButton("Добавить");
        combo1.setPreferredSize(new Dimension(100, 20));*/

        panel.setPreferredSize(new Dimension(100, 100));
        panel.setOpaque(true);

        /*panel.add(combo1);
        panel.add(textForCombo1);
        panel.add(AddButton);*/
    }

    public JPanel getPanel() {

        return panel;
    }
}
