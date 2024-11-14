public class Number implements Comparable<Number> {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int compare(Number other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}