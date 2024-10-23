public class House {
    public final int floors;

    public House(int floors) {
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

    public int getFloors() {
        return floors;
    }
}