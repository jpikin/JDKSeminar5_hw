import java.util.ArrayList;
import java.util.List;

public class Table {

    private static List<TableLocation> table = new ArrayList<>();

    public static void createTable() {
        for (int i = 1; i <= 5; i++) {
            table.add(new Fork(i));
            table.add(new Sage());
        }
        setForks(table);
    }

    private static void setForks(List<TableLocation> lst) {
        for (int i = 1; i < lst.size(); i += 2) {
            if (i < 9) {
                Fork f2 = (Fork) lst.get(i - 1);
                Fork f1 = (Fork) lst.get(i + 1);
                lst.get(i).setFork(f1, f2);
            } else {
                Fork f1 = (Fork) lst.get(0);
                Fork f2 = (Fork) lst.get(i - 1);
                lst.get(i).setFork(f1, f2);
            }
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
}
