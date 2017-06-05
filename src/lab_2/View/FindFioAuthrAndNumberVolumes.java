package lab_2.View;

import lab_2.SearchAndDelStr.FioNumbVolumesSearch;
import lab_2.SearchAndDelStr.NameSearch;
import lab_2.SearchAndDelStr.SearchAbstrClass;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class FindFioAuthrAndNumberVolumes {
    private JPanel panel;

    private JTextField firstNameAuthor;
    private JTextField lastNameAuthor;
    private JTextField surNameAuthor;
    private JTextField numberVolumesMin;
    private JTextField numberVolumesMax;

    public FindFioAuthrAndNumberVolumes(ActionListener actionListener) {

        panel = new JPanel();
        panel = new JPanel();
        panel.add(new JLabel("Имя автора"));
        firstNameAuthor = new JTextField(35);
        panel.add(firstNameAuthor);
        panel.add(new JLabel("Фамилия автора"));
        lastNameAuthor = new JTextField(35);
        panel.add(lastNameAuthor);
        panel.add(new JLabel("Отчество автора"));
        surNameAuthor = new JTextField(35);
        panel.add(surNameAuthor);
        panel.add(new JLabel("Число томов"));
        panel.add(new JLabel("Нижний предел"));
        numberVolumesMin = new JTextField(35);
        panel.add(numberVolumesMin);
        panel.add(new JLabel("Число томов"));
        panel.add(new JLabel("Верхний предел"));
        numberVolumesMax = new JTextField(35);
        panel.add(numberVolumesMax);

        JButton authBut = new JButton("Поиск");
        panel.add(authBut);
        authBut.addActionListener(actionListener);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getFirstNameAuthor() {
        return firstNameAuthor.getText();
    }

    public String getLastNameAuthor() {
        return lastNameAuthor.getText();
    }

    public String getSurNameAuthor() {
        return surNameAuthor.getText();
    }

    public String getNumberVolumesMin() {
        return numberVolumesMin.getText();
    }

    public String getNumberVolumesMax() {
        return numberVolumesMax.getText();
    }

    public SearchAbstrClass getSearchBook() {
        if (getFirstNameAuthor().equals("") || getLastNameAuthor().equals("") || getSurNameAuthor().equals("") ||
                getNumberVolumesMin().equals("") || getNumberVolumesMax().equals("")) {
            JOptionPane.showMessageDialog(null, "Проверьте введенные данные!");
        }
        return new FioNumbVolumesSearch(getLastNameAuthor(), getFirstNameAuthor(), getSurNameAuthor(), getNumberVolumesMin(), getNumberVolumesMax());
    }

}
