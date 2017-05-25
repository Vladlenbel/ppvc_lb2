package lab_2.SearchAndDelStr;

import Model.BookInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladlen on 11.05.2017.
 */
public class TotalVolumesSearch implements SearchAbstrClass {
    private String totalVolumes;
    private int radioBatton;


    public TotalVolumesSearch(String totalVolumes, int radioBatton) {
        this.totalVolumes = totalVolumes;
        this.radioBatton = radioBatton;
    }

    @Override
    public List<BookInfo> searchPattern(List<BookInfo> bookInfos) {
        List<BookInfo> searchBook = new ArrayList<BookInfo>();
        for (BookInfo bookInfo : bookInfos)
            if (FindMethod.moreLessBoarder(Integer.parseInt(totalVolumes), bookInfo.getTotalVolumes(), radioBatton))
                searchBook.add(bookInfo);
        return searchBook;
    }
}
