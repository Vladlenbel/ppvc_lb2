package lab_2.SearchAndDelStr;

import Window.BookInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladlen on 11.05.2017.
 */
public class CircultationSearch implements SearchAbstrClass {
    private String circulation;
    private int radioBatton;


    public CircultationSearch (String circulation, int radioBatton) {
        this.circulation = circulation;
        this.radioBatton = radioBatton;
    }

    @Override
    public List<BookInfo> searchPattern(List<BookInfo> bookInfos) {
        List<BookInfo> searchBook = new ArrayList<BookInfo>();
        for(BookInfo bookInfo:bookInfos)
            if(FindMethod.moreLessBoarder(Integer.parseInt(circulation), bookInfo.getCirculation(), radioBatton))
                searchBook.add(bookInfo);
        return searchBook;
    }
}
