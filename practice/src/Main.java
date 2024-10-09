import java.util.Random;
import java.util.Scanner;

//Вариант 26
public class Main {
    public static int inputSingleDigit(Scanner scanner) {
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num >= 0 && num <= 9) {
                    break;
                } else {
                    System.out.println("Введите однозначное число (от 0 до 9):");
                }
            } else {
                System.out.println("Неверный ввод! Введите однозначное число (от 0 до 9):");
                scanner.next();
            }
        }
        return num;
    }

    public static int inputInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка ввода! Введите целое число:");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String inputDayOfWeek(Scanner scanner) {
        String day;
        while (true) {
            day = scanner.nextLine().trim().toLowerCase();
            if (day.equals("понедельник") || day.equals("вторник") || day.equals("среда") ||
                    day.equals("четверг") || day.equals("пятница") || day.equals("суббота") || day.equals("воскресенье")) {
                break;
            } else {
                System.out.println("Это не день недели. Введите корректный день недели:");
            }
        }
        return day;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        while (true) {
            System.out.println("Выберите номер задачи (1.2, 1.4, ..., 4.10) или 0 для выхода:");
            String task = scanner.next();

            switch (task) {
                case "1.2":
                    System.out.println("Введите число для суммы двух последних цифр:");
                    int x12 = inputInt(scanner);
                    System.out.println("Результат: " + main.sumLastNums(x12));
                    break;

                case "1.4":
                    System.out.println("Введите число для проверки, является ли оно положительным:");
                    int x14 = inputInt(scanner);
                    System.out.println("Результат: " + main.isPositive(x14));
                    break;

                case "1.6":
                    System.out.println("Введите символ для проверки, является ли он заглавной буквой:");
                    char x16 = scanner.next().charAt(0);
                    if (Character.isLetter(x16)) {
                        System.out.println("Результат: " + main.isUpperCase(x16));
                    } else {
                        System.out.println("Введите корректный символ буквы.");
                    }
                    break;

                case "1.8":
                    System.out.println("Введите два числа для проверки, является ли одно делителем другого:");
                    int a18 = inputInt(scanner);
                    int b18 = inputInt(scanner);
                    System.out.println("Результат: " + main.isDivisor(a18, b18));
                    break;

                case "1.10":
                    int result = 0;

                    System.out.print("Введите первое число: ");
                    result = scanner.nextInt();

                    for (int i = 1; i <= 4; i++) {
                        System.out.print("Введите следующее число: ");
                        int nextNumber = scanner.nextInt();

                        result = main.lastNumSum(result, nextNumber);
                        System.out.println("Промежуточная сумма: " + result);
                    }

                    System.out.println("Итого: " + result);
                    break;

                case "2.2":
                    System.out.println("Введите два числа для безопасного деления:");
                    int x22 = inputInt(scanner);
                    int y22 = inputInt(scanner);
                    System.out.println("Результат: " + main.safeDiv(x22, y22));
                    break;

                case "2.4":
                    System.out.println("Введите два числа для сравнения:");
                    int a24 = inputInt(scanner);
                    int b24 = inputInt(scanner);
                    System.out.println("Результат: " + main.makeDecision(a24, b24));
                    break;

                case "2.6":
                    System.out.println("Введите три числа для проверки суммы:");
                    int x26 = inputInt(scanner);
                    int y26 = inputInt(scanner);
                    int z26 = inputInt(scanner);
                    System.out.println("Результат: " + main.sum3(x26, y26, z26));
                    break;

                case "2.8":
                    System.out.println("Введите возраст:");
                    int age = inputInt(scanner);
                    if (age >= 0) {
                        System.out.println("Результат: " + main.age(age));
                    } else {
                        System.out.println("Возраст не может быть отрицательным.");
                    }
                    break;

                case "2.10":
                    System.out.println("Введите название дня недели:");
                    scanner.nextLine();
                    String day = inputDayOfWeek(scanner);
                    main.printDays(day);
                    break;

                case "3.2":
                    System.out.println("Введите число для реверса последовательности:");
                    int x32 = inputInt(scanner);
                    if (x32 >= 0) {
                        System.out.println("Результат: " + main.reverseListNums(x32));
                    } else {
                        System.out.println("Число должно быть неотрицательным.");
                    }
                    break;

                case "3.4":
                    System.out.println("Введите два числа для возведения в степень:");
                    int x34 = inputInt(scanner);
                    int y34 = inputInt(scanner);
                    if (y34 >= 0) {
                        System.out.println("Результат: " + main.pow(x34, y34));
                    } else {
                        System.out.println("Степень должна быть неотрицательной.");
                    }
                    break;

                case "3.6":
                    System.out.println("Введите число для проверки одинаковости цифр:");
                    int x36 = inputInt(scanner);
                    System.out.println("Результат: " + main.equalNum(x36));
                    break;

                case "3.8":
                    System.out.println("Введите высоту треугольника:");
                    int x38 = inputInt(scanner);
                    if (x38 > 0) {
                        main.leftTriangle(x38);
                    } else {
                        System.out.println("Высота треугольника должна быть больше 0.");
                    }
                    break;

                case "3.10":
                    main.guessGame();
                    break;

                case "4.2":
                    System.out.println("Введите массив через пробелы:");
                    scanner.nextLine();
                    String[] input42 = scanner.nextLine().split(" ");
                    int[] arr42 = new int[input42.length];
                    for (int i = 0; i < input42.length; i++) {
                        arr42[i] = Integer.parseInt(input42[i]);
                    }
                    System.out.println("Введите число для поиска последнего вхождения:");
                    int x42 = inputInt(scanner);
                    System.out.println("Результат: " + main.findLast(arr42, x42));
                    break;

                case "4.4":
                    System.out.println("Введите массив через пробелы:");
                    scanner.nextLine();
                    String[] input44 = scanner.nextLine().split(" ");
                    int[] arr44 = new int[input44.length];
                    for (int i = 0; i < input44.length; i++) {
                        arr44[i] = Integer.parseInt(input44[i]);
                    }
                    System.out.println("Введите число для вставки и позицию:");
                    int x44 = inputInt(scanner);
                    int pos44 = inputInt(scanner);
                    int[] result44 = main.add(arr44, x44, pos44);
                    System.out.print("Результат: ");
                    for (int num : result44) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;

                case "4.6":
                    System.out.println("Введите массив для реверса через пробелы:");
                    scanner.nextLine();
                    String[] input46 = scanner.nextLine().split(" ");
                    int[] arr46 = new int[input46.length];
                    for (int i = 0; i < input46.length; i++) {
                        arr46[i] = Integer.parseInt(input46[i]);
                    }
                    main.reverse(arr46);
                    System.out.print("Результат: ");
                    for (int num : arr46) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;

                case "4.8":
                    System.out.println("Введите первый массив через пробелы:");
                    scanner.nextLine();
                    String[] input48_1 = scanner.nextLine().split(" ");
                    int[] arr48_1 = new int[input48_1.length];
                    for (int i = 0; i < input48_1.length; i++) {
                        arr48_1[i] = Integer.parseInt(input48_1[i]);
                    }
                    System.out.println("Введите второй массив через пробелы:");
                    String[] input48_2 = scanner.nextLine().split(" ");
                    int[] arr48_2 = new int[input48_2.length];
                    for (int i = 0; i < input48_2.length; i++) {
                        arr48_2[i] = Integer.parseInt(input48_2[i]);
                    }
                    int[] result48 = main.concat(arr48_1, arr48_2);
                    System.out.print("Результат: ");
                    for (int num : result48) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;

                case "4.10":
                    System.out.println("Введите массив через пробелы:");
                    scanner.nextLine();
                    String[] input410 = scanner.nextLine().split(" ");
                    int[] arr410 = new int[input410.length];
                    for (int i = 0; i < input410.length; i++) {
                        arr410[i] = Integer.parseInt(input410[i]);
                    }
                    int[] result410 = main.deleteNegative(arr410);
                    System.out.print("Результат: ");
                    for (int num : result410) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;

                case "0":
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неверный выбор задания.");
                    break;
            }
        }
    }

    //Задание 1.2
    public int sumLastNums (int x)
    {
        return (x % 10) + (((x - (x % 10)) % 100) / 10);
    }

    //Задание 1.4
    public boolean isPositive (int x)
    {
            return x > 0;
    }

    //Задание 1.6
    public boolean isUpperCase (char x)
    {
        return x >= 'A' && x <= 'Z';
    }

    //Задание 1.8
    public boolean isDivisor (int a, int b)
    {
        return a % b == 0 || b % a == 0;
    }

    //Задание 1.10
    public int lastNumSum(int a, int b)
    {
        return (a % 10) + (b % 10);
    }

    //Задание 2.2
    public double safeDiv (int x, int y)
    {
        if(y == 0)
            return 0;
        else
            return x / y;
    }

    //Задание 2.4
    public String makeDecision (int x, int y)
    {
        if(x > y)
            return x + " > " + y;
        else
            return x + " < " + y;
    }

    //Задание 2.6
    public boolean sum3 (int x, int y, int z)
    {
        return x + y == z || x + z == y || z + y == x;
    }

    //Задание 2.8
    public String age(int x) {
        String suffix;

        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;

        if (lastDigit == 1 && lastTwoDigits != 11) {
            suffix = "год";
        } else if (lastDigit >= 2 && lastDigit <= 4 && (lastTwoDigits < 12 || lastTwoDigits > 14)) {
            suffix = "года";
        } else {
            suffix = "лет";
        }

        return x + " " + suffix;
    }

    //Задание 2.10
    public void printDays (String x)
    {
        switch (x.toLowerCase()) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
                break;
        }
    }

    //Задание 3.2
    public String reverseListNums(int x)
    {
        String nums = "";

        for(int i = x; i >= 0; i--)
        {
            nums += i + " ";
        }
        return nums;
    }

    //Задание 3.4
    public int pow (int x, int y)
    {
        if (y == 0) {
            return 1;
        }

        int result = 1;

        for (int i = 0; i < y; i++) {
            result *= x;
        }

        return result;
    }

    //Задание 3.6
    public boolean equalNum (int x)
    {
        int lastDigit = x % 10;
        x /= 10;

        while (x > 0) {
            if (x % 10 != lastDigit) {
                return false;
            }
            x /= 10;
        }

        return true;
    }

    //Задание 3.8
    public void leftTriangle (int x)
    {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //Задание 3.10
    public void guessGame()
    {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int target = random.nextInt(10);
        int attempts = 0;
        int guess = -1;

        System.out.println("Введите число от 0 до 9:");

        while (guess != target) {
            guess = scanner.nextInt();
            attempts++;

            if (guess == target) {
                System.out.println("Вы угадали!");
            } else {
                System.out.println("Вы не угадали, введите число от 0 до 9:");
            }
        }

        System.out.println("Вы отгадали число за " + attempts + " попытки.");
    }

    //Задание 4.2
    public int findLast (int[] arr, int x)
    {
        int lastIndex = -1;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == x)
            {
                lastIndex = i;
            }
        }

        return lastIndex;
    }

    //Задание 4.4 не робит поправить
    public int[]add (int[] arr, int x, int pos)
    {
        int[] result = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        result[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }

        return result;
    }

    //Задание 4.6
    public void reverse (int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    //Задание 4.8 не робит починить
    public int[] concat (int[] arr1,int[] arr2)
    {
        int[] result = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }

        return result;
    }

    //Задание 4.10
    public int[] deleteNegative (int[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                count++;
            }
        }

        int[] mas = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                mas[index++] = arr[i];
            }
        }

        return mas;
    }
}