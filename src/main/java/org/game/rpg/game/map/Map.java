package org.game.rpg.game.map;

public interface Map {
    void goRight();
    void goLeft();
    void goUp();
    void goDown();
    boolean enemyRemaining();
}
