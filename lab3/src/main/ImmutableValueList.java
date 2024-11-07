package main;

import java.util.Arrays;
import java.util.List;

class ImmutableValueList {
    private final int[] values;

    public ImmutableValueList(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        this.values = Arrays.copyOf(values, values.length);
    }

    public ImmutableValueList(List<Integer> valuesList) {
        if (valuesList == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        this.values = valuesList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static ImmutableValueList of(int... values) {
        if (values == null) {
            throw new IllegalArgumentException("Аргументы не могут быть null");
        }
        return new ImmutableValueList(values);
    }

    public int get(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return values[index];
    }

    public void set(int index, int value) {
        throw new UnsupportedOperationException("Нельзя изменить значение, список неизменяемый.");
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int size() {
        return values.length;
    }

    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}