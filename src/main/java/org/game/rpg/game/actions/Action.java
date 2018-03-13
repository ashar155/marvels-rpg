package org.game.rpg.game.actions;

public enum Action {
    START("Start"),
    RESUME("Resume"),
    HELP("Help"),
    STORY("Story");

    private String name;

    Action(String name) {
        this.name = name;
    }

    public static final String TITLE = "Welcome to Marvel's Universe\nChoose Action";
    public static final String FOOTER_MESSAGE = "Please put operation number: ";

    @Override
    public String toString() {
        return  name;
    }
}
