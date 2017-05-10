package Model;

import Window.BookInfo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladlen on 09.05.2017.
 */
public class TableModel {
    List<BookInfo> bookInfos;

    public TableModel(){
        bookInfos = new ArrayList<BookInfo>();
    }

    public List<BookInfo> getBookInfo() {
        return bookInfos;
    }

    BookInfo get (int ind){
        return bookInfos.get(ind);
    }
    public  void add (BookInfo bookInfo){
        bookInfos.add(bookInfo);
    }
}
