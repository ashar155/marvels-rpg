package org.game.rpg.game.map;

public interface MapView<T> {
    void viewMap();
    void updateUserPosition(Direction direction);
}
