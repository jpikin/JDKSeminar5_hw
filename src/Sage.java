import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sage extends Thread implements TableLocation{
    private static final Random random = new Random();
    private static final List<String> names = createNameList();
    private final String  name;
    private int eatCount = 0;

    public Sage() {
        this.name = setName();
    }

    public int getEatCount() {
        return this.eatCount;
    }

    public void setEatCount(){
        eatCount++;
    }
    public void sageEating(){
        System.out.printf("%s приступил к трапезе", name);
    }
    public void sageThinking(){
        System.out.printf("%s приступил к размышлениям", name);
    }
    private static String setName(){
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

    @Override
    public void run() {
        try {
            takeForks();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void takeForks() throws InterruptedException {
        List<TableLocation> lst = Table.getTable();
        for (int i = 1; i < lst.size(); i+=2) {
            if(i != 9){
                Fork f1 = (Fork) lst.get(i - 1);
                Fork f2 = (Fork) lst.get(i + 1);
                if(!f1.getFork() && !f2.getFork()) {
                    f1.changeForkStatus();
                    f2.changeForkStatus();
                    System.out.printf("%s Начал жрать\n", this);
                    setEatCount();
                    sleep(500);
                    f1.changeForkStatus();
                    f2.changeForkStatus();
                    System.out.printf("%s Начал беседовать\n", this);
                    sleep(500);
                } else {
                    System.out.printf("%s Начал беседовать\n", this);
                    sleep(500);
                }

            }

        }
    }
    public void starting(){
        start();
    }
}
