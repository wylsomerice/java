import java.util.Arrays;
import java.util.List;

public class ImmutableValueList<T> {
    private final T[] values;

    @SafeVarargs
    public ImmutableValueList(T... values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public ImmutableValueList(List<T> list) {
        this.values = (T[]) list.toArray();
    }

    public T get(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы массива");
        }
        return values[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int size() {
        return values.length;
    }
}
