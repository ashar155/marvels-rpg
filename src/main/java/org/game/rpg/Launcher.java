package org.game.rpg;

import org.game.rpg.game.actions.GameActionFactory;
import org.game.rpg.game.actions.Action;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

public class Launcher {

    public static void main(final String[] args) {
        launchGame();
    }

    public static void launchGame() {
        final View<Action> launchMenu = new ConsoleMenu<>(Action.TITLE, Action.FOOTER_MESSAGE , Action.values());
        GameActionFactory.getGameAction(launchMenu.readUserChoice()).action();
    }
}
