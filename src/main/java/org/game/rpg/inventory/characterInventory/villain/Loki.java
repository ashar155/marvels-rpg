package org.game.rpg.inventory.characterInventory.villain;

import org.game.rpg.inventory.weapons.Weapon;

import java.awt.*;

public class Loki extends Villain {
    private VillainType villainType = VillainType.LOKI;
    private int health = villainType.getHealth();
    private Point position;

    public Loki(Point position) {
        this.position = position;
    }

    @Override
    public Weapon selectRandomWeapon() {
        return Weapon.chooseRandom();
    }

    @Override
    public String getName() {
        return villainType.getName();
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
}
