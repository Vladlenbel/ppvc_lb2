package lab_2.SearchAndDelStr;

import Window.BookInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladlen on 10.05.2017.
 */
public class NamePublHouseSearch implements SearchAbstrClass {
    private String lastName;
    private String firstName;
    private String fatherName;
    private String publishingHouse;

    public NamePublHouseSearch(String lastName, String firstName, String fatherName, String publishingHouse) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.publishingHouse = publishingHouse;
    }

    @Override
    public List<BookInfo> searchPattern(List<BookInfo> bookInfos) {
        List<BookInfo> searchBook= new ArrayList<BookInfo>();
        for(BookInfo bookInfo:bookInfos)
            if(FindMethod.correctName(lastName,bookInfo.getLastName()) && FindMethod.correctName(firstName,bookInfo.getFirstName())
                    && FindMethod.correctName(fatherName,bookInfo.getFatherName()) && FindMethod.correctName(publishingHouse,bookInfo.getPublishingHouse()))
                searchBook.add(bookInfo);
        return searchBook;
    }

}
