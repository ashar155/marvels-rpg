package org.game.rpg.inventory.characterInventory.hero;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.weapons.Weapon;

public abstract class Hero implements Character {
    public abstract Weapon getWeapon();
    public abstract Weapon[] getWeaponList();
    public abstract void setWeapon(Weapon weapon);
}
