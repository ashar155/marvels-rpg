package org.game.rpg.inventory.characterInventory;

public interface Character {
    String getName();
    int health();
    void decreaseHealth(int damage);
}
