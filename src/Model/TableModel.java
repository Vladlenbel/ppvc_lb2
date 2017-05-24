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
    private int thisPage;
    private int recordOnPage;


    public TableModel(){

        bookInfos = new ArrayList<BookInfo>();
        thisPage = 1;
        recordOnPage = 5;

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

    public int getRecordOnPage() {
        return recordOnPage;
    }

    public int getThisPage(){
        return thisPage;
    }

    public void nextPage(){
        boolean hasNextPage=bookInfos.size() > recordOnPage * (thisPage - 1) + recordOnPage;
        if (hasNextPage)
            thisPage++;
    }

    public void prevPage(){
        if (thisPage > 1)
            thisPage--;

    }

    public void firstPage(){
        if (thisPage > 1)
            thisPage = 1;

    }

    public void lastPage(){
        if (thisPage != getNumberMaxPage())
            thisPage = getNumberMaxPage();

    }

    public int getNumberMaxPage() {
        return ((bookInfos.size() - 1)/ recordOnPage) + 1;
    }

    public void setRecordOnPage(int recordOnPage) {
        this.recordOnPage = recordOnPage;
    }

}
