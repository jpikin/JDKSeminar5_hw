import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sage implements TableLocation{
    static Random random = new Random();
    static List<String> names = createNameList();
    private String name;

    public Sage(String name) {
        this.name = name;
    }

    public void sageEating(){
        System.out.printf("%s приступил к трапезе", name);
    }
    public void sageThinking(){
        System.out.printf("%s приступил к размышлениям", name);
    }
    public static String setName(){
        int num = random.nextInt(0,names.size());
        String newName = names.get(num);
        names.remove(num);
        return newName;
    }
    private static List<String> createNameList() {
        List<String> list = new ArrayList<>();
        list.add("Аристотель");
        list.add("Платон");
        list.add("Диоген");
        list.add("Пифагор");
        list.add("Сократ");
        return list;
    }
    @Override
    public String toString() {
        return String.format("Философ %s", name);
    }
}
