import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    //Задача 2.4
    public static ImmutableValueList<Integer> fillImmutableList() {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            tempList.add(i);
        }
        return new ImmutableValueList<>(tempList);
    }

    //Задача 3.1
    public static <T, P> List<P> applyToList(List<T> inputList, Function<T, P> function) {
        List<P> resultList = new ArrayList<>();
        for (T element : inputList) {
            resultList.add(function.apply(element));
        }
        return resultList;
    }

    //Задача 3.2
    public static <T> List<T> filterList(List<T> inputList, Predicate<T> condition) {
        List<T> resultList = new ArrayList<>();
        for (T element : inputList) {
            if (condition.test(element)) {
                resultList.add(element);
            }
        }
        return resultList;
    }

    //Задача 3.3
    public static <T> T reduce(List<T> inputList, BinaryOperator<T> reducer, T identity) {
        T result = identity;
        for (T element : inputList) {
            result = reducer.apply(result, element);
        }
        return result;
    }

    //Задача 3.4
    public static <T, P extends Collection<T>> P collect(
            List<T> inputList,
            Supplier<P> collectionFactory,
            Function<List<T>, List<T>> collectorFunction
    ) {
        P result = collectionFactory.get();
        result.addAll(collectorFunction.apply(inputList));
        return result;
    }

    public static <T, K, V> Map<K, V> collectToMap(
            List<T> inputList,
            Supplier<Map<K, V>> mapFactory,
            Function<List<T>, Map<K, V>> mapFunction
    ) {
        Map<K, V> result = mapFactory.get();
        result.putAll(mapFunction.apply(inputList));
        return result;
    }

    public static void main(String[] args) {

        System.out.println("Задача 1.3\n");

        Number number1 = new Number(5);
        Number number2 = new Number(10);

        System.out.println("Результат сравнения: " + number1.compare(number2));
        System.out.println("Результат сравнения: " + number2.compare(number1));


        System.out.println("\nЗадача 1.6\n");

        ImmutableValueList<Integer> intList = new ImmutableValueList<>(1, 2, 3, 4, 5);
        System.out.println("Список целых чисел: " + intList);

        ImmutableValueList<String> stringList = new ImmutableValueList<>(Arrays.asList("Барсик", "Булочка", "Пушок", "Берлиоз"));
        System.out.println("Список строк: " + stringList);

        System.out.println("Первое значение в списке целых чисел: " + intList.get(0));
        System.out.println("Размер списка целых чисел: " + intList.size());
        System.out.println("Список пуст: " + intList.isEmpty());

        System.out.println("\nЗадача 2.4\n");

        ImmutableValueList<Integer> immutableList = fillImmutableList();

        System.out.println("Заполненный ImmutableValueList: " + immutableList);

        System.out.println("\nЗадача 3.1\n");

        // 1. strings
        List<String> stringList31 = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengthList = applyToList(stringList31, String::length);
        System.out.println("Длины строк: " + lengthList);

        // 2. negative to positive
        List<Integer> numberList = Arrays.asList(1, -3, 7);
        List<Integer> positiveList = applyToList(numberList, x -> Math.abs(x));
        System.out.println("Положительные значения: " + positiveList);

        // 3. max values
        List<int[]> arrayOfInts = Arrays.asList(new int[]{1, 2, 3}, new int[]{-1, -5, 0}, new int[]{10, 7, 4});
        List<Integer> maxValues = applyToList(arrayOfInts, array -> Arrays.stream(array).max().orElseThrow());
        System.out.println("Максимальные значения массивов: " + maxValues);

        System.out.println("\nЗадача 3.2\n");

        // 1. strings
        List<String> stringList32 = Arrays.asList("qwerty", "asdfg", "zx");
        List<String> filteredStrings = filterList(stringList32, str -> str.length() >= 3);
        System.out.println("Строки с длиной >= 3: " + filteredStrings);

        // 2. negative
        List<Integer> numberList32 = Arrays.asList(1, -3, 7);
        List<Integer> nonPositiveNumbers = filterList(numberList32, num -> num <= 0);
        System.out.println("Неположительные числа: " + nonPositiveNumbers);

        // 3. positive array
        List<int[]> arrayOfInts32 = Arrays.asList(new int[]{1, 2, 3}, new int[]{-1, -5, 0}, new int[]{10, 7, 4});
        List<int[]> nonPositiveArrays = filterList(arrayOfInts32, array -> Arrays.stream(array).allMatch(x -> x <= 0));
        System.out.println("Массив без положительных чисел: ");
        nonPositiveArrays.forEach(array -> System.out.println(Arrays.toString(array)));

        System.out.println("\nЗадача 3.3\n");

        // 3.3.1 strings
        List<String> stringList33 = Arrays.asList("qwerty", "asdfg", "zx");
        String combinedString = reduce(stringList33, (s1, s2) -> s1 + s2, "");
        System.out.println("Объединенная строка: " + combinedString); // qwertyasdfgzx

        // 3.3.2 sum
        List<Integer> numberList33 = Arrays.asList(1, -3, 7);
        Integer sum = reduce(numberList33, Integer::sum, 0);
        System.out.println("Сумма всех чисел: " + sum); // 5

        // 3.3.3 number of elements
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(-1, -5),
                Arrays.asList(10, 7, 4)
        );

        Integer totalCount = reduce(
                listOfLists,
                (list1, list2) -> {
                    List<Integer> newList = new ArrayList<>(list1);
                    newList.addAll(list2);
                    return newList;
                },
                new ArrayList<>()
        ).size();

        System.out.println("Общее количество элементов во всех списках: " + totalCount); // 8

        System.out.println("\nЗадача 3.4\n");

        // 3.4.1 positive/negative
        List<Integer> numbers = Arrays.asList(1, -3, 7);

        Map<Boolean, List<Integer>> partitionedNumbers = collectToMap(
                numbers,
                HashMap::new,
                list -> list.stream()
                        .collect(Collectors.partitioningBy(num -> num >= 0))
        );
        System.out.println("Положительные числа: " + partitionedNumbers.get(true));
        System.out.println("Отрицательные числа: " + partitionedNumbers.get(false));

        // 3.4.2 string length
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");

        Map<Integer, List<String>> groupedByLength = collectToMap(
                strings,
                HashMap::new,
                list -> list.stream()
                        .collect(Collectors.groupingBy(String::length))
        );
        System.out.println("Строки сгруппированы по длине: " + groupedByLength);

        // 3.4.3 unique strings
        List<String> duplicateStrings = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");

        Set<String> uniqueStrings = collect(
                duplicateStrings,
                HashSet::new,
                list -> new ArrayList<>(new HashSet<>(list))
        );
        System.out.println("Уникальные строки: " + uniqueStrings);


    }
}