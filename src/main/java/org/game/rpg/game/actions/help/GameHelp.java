package org.game.rpg.game.actions.help;

import org.game.rpg.Launcher;
import org.game.rpg.game.actions.GameAction;
import org.game.rpg.util.GameUtil;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class GameHelp implements GameAction {
    @Override
    public void action() {
        List<String> helpMessage;
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("help.txt");
            helpMessage = Files.readAllLines(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            helpMessage = Collections.singletonList("Help is currently not available");
        }

        helpMessage.forEach(out::println);
        View<PostHelpAction> postHelpActionMenu = new ConsoleMenu<>("", "Please put operation number", PostHelpAction.values());
        PostHelpAction postHelpAction = postHelpActionMenu.readUserChoice();
        if(postHelpAction == PostHelpAction.RETURN) {
            Launcher.launchGame();
        } else {
            GameUtil.gameOver();
        }
    }

    public enum PostHelpAction {
        RETURN("Return to main menu"),
        EXIT("Exit game");

        private String name;

        PostHelpAction(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
