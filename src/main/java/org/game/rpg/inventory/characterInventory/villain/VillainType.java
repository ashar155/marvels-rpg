package org.game.rpg.inventory.characterInventory.villain;

import java.util.Random;

public enum VillainType {
    DOCTORDOOM("Doctor Doom", 100),
    MAGNETO("Magneto", 120),
    REDSKULL("Red Skull", 130),
    LOKI("Loki", 180),
    THANOS("Thonas", 250);

    private String name;
    private int health;

    VillainType(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public static VillainType chooseRandom() {
        final Random random = new Random();
        final int randomValue = random.nextInt(values().length);
        final VillainType[] values = values();
        return values[randomValue];
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", health=" + health;
    }
}
