package lab_2.SearchAndDelStr;

import Model.Model;


public class FileWorker {

    final String NAME_BOOK = "book_name";
    final String FIRST_NAME_AUTHOR = "first_name_author";
    final String LAST_NAME_AUTHOR = "last_name_author";
    final String SUR_NAME_AUTHOR = "sur_name_author";

    final String PUBLISHING_HOUSE = "publishing_house";
    final String NUMBER_VOLUMES = "number_volumes";
    final String CIRCULATION = "circulation";
    final String TOTAL_VOLUMES = "total_volumes";
    final String BOOK_INFO = "book_info";
    final String BOOK_INFOS = "book_infos";


    final String EXTENSION = "xml";
    Model model;
    public OpenFile openFile;
    public SaveFile saveFile;

    public FileWorker(Model model) {
        this.model = model;
        FileWorker that = this;
        openFile = new OpenFile(that);
        saveFile = new SaveFile(that);

    }

}