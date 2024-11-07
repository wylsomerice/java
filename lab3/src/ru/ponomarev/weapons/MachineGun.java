package ru.ponomarev.weapons;

public class MachineGun extends Pistol {
    private final int fireRate;
    public MachineGun() {
        super(30);
        this.fireRate = 30;
    }

    public MachineGun(int maxBullets) {
        super(maxBullets);
        this.fireRate = maxBullets / 2;
    }

    public MachineGun(int maxBullets, int fireRate) {
        super(maxBullets);
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом.");
        }
        this.fireRate = fireRate;
    }

    @Override
    public void shoot() {
        int shots = Math.min(fireRate, ammo);
        for (int i = 0; i < shots; i++) {
            System.out.println("Бах!");
        }
        ammo -= shots;
        if (shots == 0) {
            System.out.println("Клац!");
        }
    }

    public void shootForSeconds(int seconds) {
        int totalShots = fireRate * seconds;
        int shots = Math.min(totalShots, ammo);
        for (int i = 0; i < shots; i++) {
            System.out.println("Бах!");
        }
        ammo -= shots;
        if (shots < totalShots) {
            System.out.println("Клац!");
        }
    }

    public int getFireRate() {
        return fireRate;
    }
}