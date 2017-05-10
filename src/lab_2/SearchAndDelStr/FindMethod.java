package lab_2.SearchAndDelStr;

/**
 * Created by Vladlen on 10.05.2017.
 */
public class FindMethod {
    public static boolean correctName(String name,String searchName){
        return name.equals(searchName);
    }

    public static boolean numberInBoarder(int board1, int board2, int tabBoard){
        if(board1<tabBoard && tabBoard< board2){
            return true;
        }
        return false;
    }

    public static boolean moreLessBoarder (int panelNumber, int tableNumber, int boarder){
        if (panelNumber > tableNumber && boarder == 1){
            return true;
        }
        if (panelNumber < tableNumber && boarder == 2){
            return true;
        }
        return false;
    }
}
