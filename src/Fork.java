import java.util.concurrent.atomic.AtomicBoolean;

public class Fork {
    private boolean isUsing = false;

    public void changeForkStatus(){
        isUsing = !isUsing;
    }
}
