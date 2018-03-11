package org.game.rpg;

import org.game.rpg.game.actions.GameActionFactory;
import org.game.rpg.game.actions.Action;
import org.game.rpg.view.console.Menu;

public class Launcher {

    public static void main(String[] args) {
        Menu<Action> launchMenu = new Menu<>("Welcome to Marvel's Universe", "Please choose operation number: ", Action.values());
        GameActionFactory.launch(launchMenu.readUserChoice()).action();
    }
}
