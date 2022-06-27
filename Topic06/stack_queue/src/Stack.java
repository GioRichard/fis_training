import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> list = new ArrayList<>();

    public void push(T t) {
        list.add(t);
    }

    public T pop() {
        return list.remove(list.size() - 1);
    }

    public T peek() {
        return list.get(list.size() - 1);
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
