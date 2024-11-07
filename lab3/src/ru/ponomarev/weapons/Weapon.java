package ru.ponomarev.weapons;

public abstract class Weapon {
    protected int ammo;

    protected int maxAmmo;

    // Конструктор класса Weapon, инициализирующий количество патронов
    public Weapon(int ammo) {
        if (ammo < 0) throw new RuntimeException("Количество патронов не может быть отрицательным");
        this.ammo = ammo;
    }

    public Weapon(int ammo, int maxAmmo) {
        this.maxAmmo = maxAmmo;
        this.ammo = Math.min(ammo, maxAmmo);
    }

    public abstract void shoot();

    public int ammo() {
        return ammo;
    }

    public boolean getAmmo() {
        if (ammo == 0) return false;
        ammo--;
        return true;
    }

    public int load(int ammo) {
        if (ammo < 0) throw new RuntimeException("Количество патронов не может быть отрицательным");
        int tmp = ammo;
        this.ammo = ammo;
        return tmp;
    }
}
