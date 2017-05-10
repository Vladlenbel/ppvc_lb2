package lab_2.SearchAndDelStr;

import Window.BookInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladlen on 10.05.2017.
 */
public class BookSearch implements SearchAbstrClass {
    private String bookName;


    public BookSearch(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public List<BookInfo> searchPattern(List<BookInfo> bookInfos) {
        List<BookInfo> searchBook = new ArrayList<BookInfo>();
        for(BookInfo bookInfo:bookInfos)
            if(FindMethod.correctName(bookName,bookInfo.getBookName()) )
                searchBook.add(bookInfo);
        return searchBook;
    }
}
