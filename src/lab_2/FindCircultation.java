package lab_2;

import javax.swing.*;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class FindCircultation {
    private JPanel panel;
    private JTextField circulation;
    private final JRadioButton jrb1 = new JRadioButton("Больше");
    private final JRadioButton jrb2 = new JRadioButton("Меньше");


    public FindCircultation() {
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
    }

    public JPanel getPanel(){
        return panel;
    }

    public JTextField getCirculation(){
        return circulation;
    }

    public int getRadioBatton() {
        if (jrb1.isSelected()) {
            return 1;
        }
        if (jrb2.isSelected()){return 1;}
        return 0;
    }
}
