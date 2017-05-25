package Model;

import java.util.ArrayList;
import java.util.List;

public class BookIntoList {
    List<BookInfo> bookInfoList;

    BookIntoList() {
        bookInfoList = new ArrayList<BookInfo>();
    }

    BookInfo get(int ind) {
        return bookInfoList.get(ind);
    }

    void add(BookInfo bookInfo) {
        bookInfoList.add(bookInfo);
    }
}
