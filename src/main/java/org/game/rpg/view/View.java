package org.game.rpg.view;

public interface View<T> {
    void printMenu();
    T readUserChoice();
}
