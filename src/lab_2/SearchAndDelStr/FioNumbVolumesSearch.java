package lab_2.SearchAndDelStr;

import Window.BookInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladlen on 10.05.2017.
 */
public class FioNumbVolumesSearch implements SearchAbstrClass {
    private String lastName;
    private String firstName;
    private String fatherName;
    private String numberVolumesMin;
    private String numberVolumesMax;

    public FioNumbVolumesSearch(String lastName, String firstName, String fatherName,
                                String numberVolumesMin, String numberVolumesMax) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.numberVolumesMin = numberVolumesMin;
        this.numberVolumesMax = numberVolumesMax;
    }

    @Override
    public List<BookInfo> searchPattern(List<BookInfo> bookInfos) {
        List<BookInfo> searchBook = new ArrayList<BookInfo>();
        for(BookInfo bookInfo:bookInfos)
            if(FindMethod.correctName(lastName,bookInfo.getLastName()) &&
                    FindMethod.correctName(firstName,bookInfo.getFirstName())
                    && FindMethod.correctName(fatherName,bookInfo.getFatherName())&&
                    FindMethod.numberInBoarder(Integer.parseInt(numberVolumesMin),Integer.parseInt(numberVolumesMax), bookInfo.getNumberVolumes() ) )
                searchBook.add(bookInfo);
        return searchBook;
    }
}
