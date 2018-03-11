package org.game.rpg.game.map;

public enum Direction {
    RIGHT("Right"),
    LEFT("Left"),
    UP("Up"),
    DOWN("Down");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    public static final String TITLE = "Explore";
    public static final String FOOTER_MESSAGE = "Please put operation number: ";

    @Override
    public String toString() {
        return name;
    }
}
