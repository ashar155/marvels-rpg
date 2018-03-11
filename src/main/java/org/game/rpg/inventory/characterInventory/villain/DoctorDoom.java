package org.game.rpg.inventory.characterInventory.villain;

import org.game.rpg.inventory.weapons.Weapon;

public class DoctorDoom extends Villain {
    private VillainType villainType = VillainType.DOCTORDOOM;
    private int health = villainType.getHealth();

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
}
