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
    private int currentPage;
    private int booksOnPage ;

    public TableModel(){

        bookInfos = new ArrayList<BookInfo>();
        currentPage = 1;
        booksOnPage = 5;
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

    public void firstPage(){
        if (currentPage > 1)
            currentPage = 1;

    }


    public void setBooksOnPage(int booksOnPage) {
        this.booksOnPage = booksOnPage;
    }

    public int getBooksOnPage() {
        return booksOnPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
