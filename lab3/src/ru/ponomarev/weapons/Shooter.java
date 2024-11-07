package ru.ponomarev.weapons;

import ru.ponomarev.weapons.*;

public class Shooter {
    private String name;
    private Weapon weapon;

    public Shooter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon != null) {
            System.out.println(name + " стреляет");
            weapon.shoot();
        } else {
            System.out.println(name + ": не могу участвовать в перестрелке");
        }
    }
}