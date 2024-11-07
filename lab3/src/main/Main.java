package main;

import ru.ponomarev.weapons.*;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Main {

    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }

    public static void main(String[] args) {

       /* if (args.length < 2) {
            System.out.println("Ошибка: необходимо указать два числа в качестве аргументов командной строки.");
            return;
        }

        String xStr = args[0];
        String yStr = args[1];

        double result = power(xStr, yStr);
        System.out.println("Результат возведения " + xStr + " в степень " + yStr + " = " + result);*/

        //***********************************************//

        System.out.println("Задание 1.1\n");

        try {
            House house1 = new House(2);
            House house2 = new House(35);
            House house3 = new House(91);

            System.out.println(house1);
            System.out.println(house2);
            System.out.println(house3);

            System.out.println("\nПопытка создать дом с отрицательным количеством этажей:\n");

            House house4 = new House(-3);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }

        //***********************************************//

        System.out.println("\nЗадание 1.5\n");

        Pistol pistol = new Pistol(3, 7);

        for (int i = 0; i < 5; i++) {
            pistol.shoot();
        }

        pistol.load(8);

        for (int i = 0; i < 2; i++) {
            pistol.shoot();
        }

        pistol.unload();

        pistol.shoot();

        //***********************************************//

        System.out.println("\nЗадание 2.1\n");

        ImmutableValueList list1 = new ImmutableValueList(new int[]{1, 2, 3, 4});
        System.out.println("Список 1: " + list1);

        ImmutableValueList list2 = ImmutableValueList.of(5, 6, 7, 8, 9);
        System.out.println("Список 2: " + list2);

        List<Integer> intList = List.of(10, 11, 12);
        ImmutableValueList list3 = new ImmutableValueList(intList);
        System.out.println("Список 3: " + list3);

        System.out.println("Значение в позиции 2 списка 2: " + list2.get(2));

        try {
            list2.set(2, 15);
        } catch (UnsupportedOperationException e) {
            System.out.println("Ошибка при попытке изменения: " + e.getMessage());
        }

        System.out.println("Список 1 пустой? " + list1.isEmpty());
        System.out.println("Размер списка 1: " + list1.size());

        System.out.println("Массив значений списка 3: " + Arrays.toString(list3.toArray()));

        //***********************************************//

        System.out.println("\nЗадание 3.4\n");

        MachineGun gun1 = new MachineGun();
        MachineGun gun2 = new MachineGun(40);
        MachineGun gun3 = new MachineGun(50, 20);

        System.out.println("Автомат 1, скорострельность: " + gun1.getFireRate());
        gun1.shoot();
        gun1.shootForSeconds(2);

        System.out.println("\nАвтомат 2, скорострельность: " + gun2.getFireRate());
        gun2.shoot();
        gun2.shootForSeconds(3);

        System.out.println("\nАвтомат 3, скорострельность: " + gun3.getFireRate());
        gun3.shoot();
        gun3.shootForSeconds(4);

        //***********************************************//

        System.out.println("\nЗадание 5.8\n");

        Shooter shooter1 = new Shooter("Артур Морган");
        Shooter shooter2 = new Shooter("Мальборо");
        Shooter shooter3 = new Shooter("Клинт");

        shooter2.setWeapon(new Pistol(3));
        shooter3.setWeapon(new MachineGun(10, 3));

        shooter1.shoot();
        shooter2.shoot();
        shooter3.shoot();

        //***********************************************//

        System.out.println("\nЗадание 6.2\n");

        Point point1 = new Point(3, 5);
        Point point2 = new Point(3, 5);
        Point point3 = new Point(25, 6);

        System.out.println(point1 + " equals " + point2 + " = " +  point1.equals(point2));
        System.out.println(point1 + " equals " + point2 + " = " +  point1.equals(point3));
    }
}