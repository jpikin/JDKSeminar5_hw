import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Sage extends Thread {
    private final String name;
    private final int leftFork;
    private final int rightFork;
    private int countEat;
    private Random random;
    private CountDownLatch cdl;
    private final Table table;
    private static final List<String> names = createNameList();

    public Sage(Table table, int leftFork, int rightFork, CountDownLatch cdl) {
        this.table = table;
        this.name = setName();
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        countEat = 0;
        random = new Random();
    }

    @Override
    public void run() {
        while (countEat < 3) {
            try {
                thinking();
                eating();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
        System.out.println(name + " наелся");
        table.fillFinalList(name);
        cdl.countDown();
    }

    private void eating() throws InterruptedException {
        if (table.tryGetForks(leftFork, rightFork)) {
            System.out.println(name + " взял вилки и начал есть");
            sleep(random.nextLong(3000, 6000));
            table.putForks(leftFork, rightFork);
            System.out.println(name + " поел и положил вилки");
            countEat++;
        }
    }

    private void thinking() throws InterruptedException {
        sleep(random.nextLong(100, 2000));
    }

    private String setName() {
        Random r = new Random();
        int num = r.nextInt(0, names.size());
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
}
