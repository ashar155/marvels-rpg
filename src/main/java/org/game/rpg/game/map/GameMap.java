package org.game.rpg.game.map;

public interface GameMap {
    boolean enemyRemaining();
    void moveUser(Direction direction);
}
