package org.game.rpg.inventory.characterInventory.hero;

import org.game.rpg.inventory.weapons.Weapon;

import java.awt.*;

public class Thor extends Hero {
    private HeroType heroType = HeroType.THOR;
    private Weapon weapon;
    private int health = heroType.getHealth();
    private Point position;

    public Thor(Point position) {
        this.position = position;
    }

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
    public Point position() {
        return position;
    }

    @Override
    public void setPosition(Point newPosition) {
        this.position = position;
    }

    @Override
    public Weapon[] getWeaponList() {
        return heroType.getWeapons();
    }
}
