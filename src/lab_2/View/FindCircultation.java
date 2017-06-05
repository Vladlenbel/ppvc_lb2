package lab_2.View;

import lab_2.SearchAndDelStr.BookSearch;
import lab_2.SearchAndDelStr.CircultationSearch;
import lab_2.SearchAndDelStr.SearchAbstrClass;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class FindCircultation {
    private JPanel panel;
    private JTextField circulation;
    private final JRadioButton jrb1 = new JRadioButton("Больше");
    private final JRadioButton jrb2 = new JRadioButton("Меньше");


    public FindCircultation(ActionListener actionListener) {
        panel = new JPanel();

        panel.add(new JLabel("Тираж"));
        circulation = new JTextField(30);
        panel.add(circulation);


        ButtonGroup butGr = new ButtonGroup();
        butGr.add(jrb1);
        butGr.add(jrb2);

        panel.add(jrb1);
        panel.add(jrb2);


        JButton authBut = new JButton("Поиск");
        panel.add(authBut);
        authBut.addActionListener(actionListener);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getCirculation() {
        return circulation.getText();
    }

    public int getRadioBatton() {
        if (jrb1.isSelected()) {
            return 2;
        }
        if (jrb2.isSelected()) {
            return 1;
        }
        return 0;
    }

    public SearchAbstrClass getSearchBook() {
        if (getCirculation().equals("") || getRadioBatton() == 0) {
            JOptionPane.showMessageDialog(null, "Проверьте введенные данные!");
        }
        return new CircultationSearch(getCirculation(), getRadioBatton());
    }
}
