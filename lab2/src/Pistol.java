public class Pistol {
    private int bullets;

    public Pistol(int bullets) {
        this.bullets = bullets;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }
}