public class Time {
    private int seconds;

    public Time(int seconds) {
        this.seconds = seconds;
    }

    public String toString() {
        int totalSecondsInDay = 86400;
        int currentSeconds = seconds % totalSecondsInDay;

        int hours = currentSeconds / 3600;
        int minutes = (currentSeconds % 3600) / 60;
        int secs = currentSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}