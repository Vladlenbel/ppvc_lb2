package Window;


import Model.TableModel;

import java.util.List;

/**
 * Created by Vladlen on 09.05.2017.
 */
public class Model {

    private TableModel tableModel;

    public Model(TableModel tableModel) {
        this.tableModel=tableModel;
    }
    public TableModel getTableModel() {
        return tableModel;
    }

    public void prevPage() {
        tableModel.prevPage();
    }

    public void nextPage() {
        tableModel.nextPage();
    }

    public void lastPage() {
        tableModel.lastPage();
    }

    public void firstPage() {
        tableModel.firstPage();
    }

    public void setRecordOnPage(int recordOnPage) {
        tableModel.setRecordOnPage(recordOnPage);
    }
}
