package main;

import java.util.Objects;

public class House {
    private final int floors;

    public House(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть положительным.");
        }
        this.floors = floors;
    }

    public String toString() {
        String suffix;

        int lastDigit = floors % 10;
        int lastTwoDigits = floors % 100;

        if (lastDigit == 1 && lastTwoDigits != 11) {
            suffix = "этажом";
        } else if (lastDigit >= 2 && lastDigit <= 4 && (lastTwoDigits < 12 || lastTwoDigits > 14)) {
            suffix = "этажами";
        } else {
            suffix = "этажами";
        }

        return "Дом с " + floors + " " + suffix;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        House house = (House) obj;
        return floors == house.floors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floors);
    }
}
