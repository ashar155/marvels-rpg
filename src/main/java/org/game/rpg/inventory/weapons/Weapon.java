package org.game.rpg.inventory.weapons;

import java.util.Random;

public enum Weapon {
    MJOLNIR(10, 4),
    GAUNTLET(12, 2),
    SHIELD(0, 10),
    NORNSTONES(20, 0),
    ARMOUR(15, 1),
    ODINSWORD(6, 1),
    NULLIFIER(0, 20);

    private int attackPower;
    private int defencePower;

    Weapon(int attackPower, int defencePower) {
        this.attackPower = attackPower;
        this.defencePower = defencePower;
    }

    public static Weapon chooseRandom() {
        final Random random = new Random();
        final int randomValue = random.nextInt(values().length);
        final Weapon[] values = values();
        return values[randomValue];
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }
}
