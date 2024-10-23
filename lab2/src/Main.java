public class Main {

    public static void main(String[] args) {

        // Задание 1
        Time time1 = new Time(10);
        Time time2 = new Time(10000);
        Time time3 = new Time(100000);

        System.out.println("Задание 1.1");
        System.out.println("10 секунд: " + time1);
        System.out.println("10000 секунд: " + time2);
        System.out.println("100000 секунд: " + time3);
        System.out.println();

        House house1 = new House(1);
        House house5 = new House(5);
        House house23 = new House(23);

        System.out.println("Задание 1.2");
        System.out.println(house1);
        System.out.println(house5);
        System.out.println(house23);
        System.out.println();

        // Задание 2
        Employee petrov = new Employee("Петров");
        Employee kozlov = new Employee("Козлов");
        Employee sidorov = new Employee("Сидоров");

        Department itDepartment = new Department("IT", kozlov);

        System.out.println("Задание 2");
        petrov.setDepartment(itDepartment);
        kozlov.setDepartment(itDepartment);
        sidorov.setDepartment(itDepartment);

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
        System.out.println();

        System.out.println("Задание 3");
        System.out.println("Список сотрудников отдела " + sidorov.getDepartment().getName() + ":");
        for (Employee employee : itDepartment.getEmployees()) {
            System.out.println(employee.getName());
        }
        System.out.println();

        System.out.println("Задание 4");

        House house2 = new House(2);
        House house35 = new House(35);
        House house91 = new House(91);

        System.out.println(house2);
        System.out.println(house35);
        System.out.println(house91);
        System.out.println();
        System.out.println("Попытка изменить количество этажей: java: cannot assign a value to final variable floors");
        System.out.println();

        System.out.println("Задание 5");

        Pistol pistol = new Pistol(3);

        for (int i = 0; i < 5; i++) {
            pistol.shoot();
        }

    }
}