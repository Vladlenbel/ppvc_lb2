package lab_2.View;

import lab_2.View.BookTable;
import lab_2.SearchAndDelStr.FileWorker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vladlen on 11.05.2017.
 */
public class OpenFileRecord implements ActionListener {
    private BookTable bookTable;
    private FileWorker fileWorker;

    public OpenFileRecord(BookTable bookTable, FileWorker fileWorker) {
        this.fileWorker = fileWorker;
        this.bookTable = bookTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileWorker.openFile.openFile();
        bookTable.updateRecord();
    }
}
