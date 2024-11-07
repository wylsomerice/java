package ru.ponomarev.weapons;

public class Pistol extends Weapon {
    // Конструктор принимает начальное количество патронов
    public Pistol(int ammo) {
        super(ammo);  // Инициализация базового класса Weapon
    }

    public Pistol(int ammo, int maxAmmo) {
        super(ammo, maxAmmo);
        this.maxAmmo = maxAmmo;
        this.ammo = Math.min(ammo, maxAmmo); // Ограничиваем ammo максимумом
    }

    @Override
    public void shoot() {
        if (getAmmo()) { // Если патроны есть, выстрел происходит
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!"); // Если патронов нет, пистолет "щелкает"
        }
    }

    // Дополнительный метод для проверки текущего количества патронов
    public int getCurrentAmmo() {
        return ammo();
    }

    public void unload() {
        ammo = 0;
    }
}