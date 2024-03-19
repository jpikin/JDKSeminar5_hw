import java.util.ArrayList;
import java.util.List;

public class Table extends Thread {

    private static List<TableLocation> table = new ArrayList<>();

    public static void createTable() {
        for (int i = 1; i <= 5; i++) {
            table.add(new Fork(i));
            table.add(new Sage());
        }
    }

    public static List<TableLocation> getTable() {
        return table;
    }

    public static void starting() {
        for (int i = 1; i < 10; i += 2) {
            getTable().get(i).starting();
        }
    }

    public void takeFork() {

    }
}
