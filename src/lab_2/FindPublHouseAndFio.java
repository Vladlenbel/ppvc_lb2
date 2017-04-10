package lab_2;

import javax.swing.*;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class FindPublHouseAndFio {
    private JPanel panel;

    public FindPublHouseAndFio() {
        panel = new JPanel();

        JTextField text = new JTextField(20);
        panel.add(text);
    }

    public JPanel getPanel(){
        return panel;
    }
}

