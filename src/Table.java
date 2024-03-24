import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread{

    private final int SAGE_COUNT = 5;
    private Fork[] forks;
    private Sage[] sages;
    private CountDownLatch cdl;
    private List<String> finalList = new ArrayList<>();

    public Table() {
        forks = new Fork[SAGE_COUNT];
        sages = new Sage[SAGE_COUNT];
        cdl = new CountDownLatch(SAGE_COUNT);
        init();
    }

    @Override
    public void run() {
        System.out.println("Мудрецы собрались за столом покушать и поговорить.");
        try {
            thinkingProcess();
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        System.out.println("Все философы наелись в таком порядке:");
        for (int i = 0; i < finalList.size(); i++){
            System.out.println(i+1 + " " + finalList.get(i));
        }
    }
    public void fillFinalList(String s){
        finalList.add(s);
    }

    public synchronized boolean tryGetForks(int leftFork, int rightFork) {
        if (!forks[leftFork].isUsing() && !forks[rightFork].isUsing()){
            forks[leftFork].setUsing(true);
            forks[rightFork].setUsing(true);
            return true;
        }
        return false;
    }

    public void putForks(int leftFork, int rightFork) {
        forks[leftFork].setUsing(false);
        forks[rightFork].setUsing(false);
    }

    private void init() {
        for (int i = 0; i < SAGE_COUNT; i++) {
            forks[i] = new Fork();
        }
        for (int i = 0; i < SAGE_COUNT; i++) {
            sages[i] = new Sage(this, i, (i + 1) % SAGE_COUNT, cdl);
        }
    }

    private void thinkingProcess() {
        for (Sage sage : sages) {
            sage.start();
        }
    }
}
