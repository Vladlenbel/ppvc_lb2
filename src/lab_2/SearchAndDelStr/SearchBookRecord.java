package lab_2.SearchAndDelStr;

import Model.BookInfo;

import java.util.List;

/**
 * Created by Vladlen on 10.05.2017.
 */
public class SearchBookRecord {
    private SearchAbstrClass searchAbstrClass;

    public SearchBookRecord(SearchAbstrClass searchAbstrClass) {
        this.searchAbstrClass = searchAbstrClass;
    }

    public List<BookInfo> searchPatternSearchAbstrClass(List<BookInfo> bookInfos) {
        return searchAbstrClass.searchPattern(bookInfos);
    }
}
