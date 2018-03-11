package org.game.rpg.inventory.characterInventory.hero;

import org.game.rpg.inventory.weapons.Weapon;

public class Spiderman extends Hero {
    private HeroType heroType = HeroType.SPIDERMAN;
    private Weapon weapon;
    private int health = heroType.getHealth();

    @Override
    public String getName() {
        return heroType.getName();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int health() {
        return this.health;
    }

    @Override
    public void decreaseHealth(int damage) {
        this.health -= damage;
    }

    @Override
    public Weapon[] getWeaponList() {
        return heroType.getWeapons();
    }
}
