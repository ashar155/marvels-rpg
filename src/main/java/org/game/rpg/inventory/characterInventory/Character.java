package org.game.rpg.inventory.characterInventory;

import java.awt.*;

public interface Character {
    String getName();
    int health();
    void decreaseHealth(int damage);
    Point position();
    void setPosition(Point newPosition);
}
