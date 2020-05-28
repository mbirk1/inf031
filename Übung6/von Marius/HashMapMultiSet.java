import java.util.*;
import java.util.function.Consumer;

public class HashMapMultiSet implements MultiSet{
    public static void main(String[] args){
        MultiSet<String, Integer> Test = (MultiSet<String, Integer>) new HashMap<String, Integer>();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        List<Object> all = new ArrayList<>();

        for (int i = 0; i < values.size(); i++)
        for (int j = 0; j < frequency.get(i); j++)
        all.add(values.get(i));

        all.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public void add(Object element) {
        int index= values.indexOf(element);
        int count = frequency.get(index);

        int prevCount = 0;
        if (index != -1) {
            prevCount = frequency.get(index);
            frequency.set(index, prevCount + count);
        }
        else if (count != 0) {
            values.add(element);
            frequency.add(count);
        }

    }

    @Override
    public int count(Object element) {
        int index = values.indexOf(element);
        int number = frequency.get(index);
        return number;
    }
}
interface MultiSet<T, I extends Number> extends Iterable {
    public void add(T element);
    public default int count(T element){
        return 0;
    }
    public List<Object> values = null;
    public List<Integer> frequency = null;

}
