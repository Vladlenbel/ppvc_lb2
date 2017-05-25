package lab_2;

import lab_2.SearchAndDelStr.CircultationSearch;
import lab_2.SearchAndDelStr.SearchAbstrClass;
import lab_2.SearchAndDelStr.TotalVolumesSearch;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class FindTotalVolumes {
    private JPanel panel;

    private JTextField totalVolumes;
    private final JRadioButton jrb1 = new JRadioButton("Больше");
    private final JRadioButton jrb2 = new JRadioButton("Меньше");

    public FindTotalVolumes(ActionListener actionListener) {
        panel = new JPanel();

        panel.add(new JLabel("Итого томов"));
        totalVolumes = new JTextField(30);
        panel.add(totalVolumes);


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

    public String getTotalVolumes() {
        return totalVolumes.getText();
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
        if (getTotalVolumes().equals("") || getRadioBatton() == 0) {
            JOptionPane.showMessageDialog(null, "Проверьте введенные данные!");
        }
        return new TotalVolumesSearch(getTotalVolumes(), getRadioBatton());
    }
}
