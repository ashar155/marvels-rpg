package org.game.rpg.inventory.weapons;

import java.util.Random;

public enum Weapon {
    MJOLNIR("MJOLNIR", 10, 4),
    GAUNTLET("GAUNTLET", 12, 2),
    SHIELD("SHIELD", 0, 10),
    NORNSTONES("NORNSTONES", 20, 0),
    ARMOUR("ARMOUR", 15, 1),
    ODINSWORD("ODINSWORD", 6, 1),
    NULLIFIER("NULLIFIER", 0, 20);

    private String name;
    private int attackPower;
    private int defencePower;

    Weapon(String name, int attackPower, int defencePower) {
        this.name = name;
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

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", attackPower=" + attackPower +
                ", defencePower=" + defencePower;
    }
}
