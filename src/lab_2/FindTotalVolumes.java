package lab_2;

import javax.swing.*;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class FindTotalVolumes {
    private JPanel panel;

    private JTextField totalVolumes;
    private final JRadioButton jrb1 = new JRadioButton("Больше");
    private final JRadioButton jrb2 = new JRadioButton("Меньше");

    public FindTotalVolumes() {
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
    }

    public JPanel getPanel(){
        return panel;
    }

    public JTextField getTotalVolumes(){
        return totalVolumes;
    }

    public int getRadioBatton() {
        if (jrb1.isSelected()) {
            return 1;
        }
        if (jrb2.isSelected()){return 1;}
        return 0;
    }
}
