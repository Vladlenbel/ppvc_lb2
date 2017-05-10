package lab_2;

import lab_2.SearchAndDelStr.NameSearch;
import lab_2.SearchAndDelStr.SearchAbstrClass;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class FindFioAuthr {
    private JPanel panel;
    private JTextField firstNameAuthor;
    private JTextField lastNameAuthor;
    private JTextField surNameAuthor;

    public FindFioAuthr(ActionListener actionListener) {
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

        JButton authBut = new JButton("Поиск");
        panel.add(authBut);
        authBut.addActionListener(actionListener);
    }

    public JPanel getPanel(){
        return panel;
    }

    public String getFirstNameAuthor(){
        return firstNameAuthor.getText();
    }

    public String getLastNameAuthor(){
        return lastNameAuthor.getText();
    }

    public String getSurNameAuthor(){
        return surNameAuthor.getText();
    }

    public SearchAbstrClass getSearchBook(){
        if (getFirstNameAuthor().equals("")|| getLastNameAuthor().equals("")|| getSurNameAuthor().equals("")){
            JOptionPane.showMessageDialog(null, "Проверьте введенные данные!");
        }
        return new NameSearch(getLastNameAuthor(), getFirstNameAuthor(), getSurNameAuthor());
    }
}
