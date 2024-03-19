import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sage extends Thread implements TableLocation {
    private static final Random random = new Random();
    private static final List<String> names = createNameList();
    private final String name;
    private int eatCount = 0;
    private Fork rigthHand;
    private Fork leftHand;

    public Sage() {
        this.name = setName();
    }

    public int getEatCount() {
        return this.eatCount;
    }

    public void setEatCount() {
        eatCount++;
    }

    public void sageEating() {
        System.out.printf("%s приступил к трапезе\n", name);
        eatCount++;
    }

    public void sageThinking() {
        System.out.printf("%s приступил к размышлениям\n", name);
    }

    private static String setName() {
        int num = random.nextInt(0, names.size());
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
        while (true) {

            try {
                takeFork();
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    private boolean takeFork(){
        if (!rigthHand.getFork() && !leftHand.getFork()){
            rigthHand.start();
            leftHand.start();
            rigthHand.changeForkStatus();
            leftHand.changeForkStatus();
            sageEating();
            return true;
        } else{
            sageThinking();
            return false;
        }
    }



    public void starting() {
        start();
    }

    public void setFork(Fork f1, Fork f2) {
        this.rigthHand = f1;
        this.leftHand = f2;
    }
}
