import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {

        createTable();


    }

    private static void createTable() {
        List<TableLocation> tableLocation = new ArrayList<>();
        for (int i = 1; i <=5; i++){
            tableLocation.add(new Fork(i));
            tableLocation.add(new Sage(Sage.setName()));
        }
    }


}
