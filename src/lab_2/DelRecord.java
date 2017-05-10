package lab_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 11.04.2017.
 */
public class DelRecord {
    private JFrame frame;
    private Dialog dialog;


    public DelRecord() {

        dialog = new Dialog("Удаление записи", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame = dialog.getFrame();
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public JFrame getFrame() {

        return frame;
    }
}
