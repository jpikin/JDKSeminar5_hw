
public class Fork implements TableLocation{
    private boolean isUsing = false;
    private int forkNumber;

    public Fork(int forkNumber) {
        this.forkNumber = forkNumber;
    }

    public void changeForkStatus(){
        isUsing = !isUsing;
    }
    public boolean getFork(){
        return isUsing;
    }
    @Override
    public String toString(){
        return String.format("Вилка_%d",forkNumber);
    }

    public void starting(){}
}
