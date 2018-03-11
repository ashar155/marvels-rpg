package org.game.rpg.inventory.characterInventory.hero;

import org.game.rpg.inventory.weapons.Weapon;

import java.util.Arrays;

public enum HeroType {
    SPIDERMAN("Spider Man", 90, Weapon.NULLIFIER, Weapon.MJOLNIR, Weapon.GAUNTLET),
    BATMAN("Batman", 100, Weapon.MJOLNIR, Weapon.SHIELD),
    IROMMAN("Iron man", 120, Weapon.MJOLNIR, Weapon.SHIELD),
    HULK("Hulk", 150, Weapon.MJOLNIR, Weapon.SHIELD),
    THOR("Thor", 200, Weapon.MJOLNIR, Weapon.SHIELD);

    public static final String TITLE = "Choose Character";
    public static final String FOOTER_MESSAGE = "Please enter operation number";

    private String name;
    private int health;
    private Weapon[] weapons;

    HeroType(String name, int health, Weapon... weapons) {
        this.name = name;
        this.health = health;
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", health=" + health +
                ", weapons=" + Arrays.toString(weapons);
    }
}
