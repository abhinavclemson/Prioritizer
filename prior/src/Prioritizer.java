import java.util.ArrayList;
interface Prioritizer<T>{
    public void insert(T t);
    public void removeNextInOrder();
    public void removeAny();
    public boolean isInsertionPhase();
    public void changePhase();
    public int size();
}

