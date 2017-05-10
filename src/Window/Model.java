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
}
