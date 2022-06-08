import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    public T remove() {
        return list.remove(0);
    }

    public T peek() {
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean empty() {
        return list.isEmpty() ? true : false;
    }

    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
