package lab_2.View;

import lab_2.SearchAndDelStr.FileWorker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 11.05.2017.
 */
public class SaveFileRecord implements ActionListener {
    private FileWorker fileWorker;

    public SaveFileRecord(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileWorker.saveFile.saveFile();

    }
}
