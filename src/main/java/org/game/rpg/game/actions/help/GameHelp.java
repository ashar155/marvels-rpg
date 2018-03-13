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
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.Collections.singletonList;

public class GameHelp implements GameAction {

    private static final List<String> HELP_CURRENTLY_UNAVAILABLE_MESSAGE = singletonList("Help is currently not available");

    @Override
    public void action() {
        List<String> helpMessage;
        try {
            URL resource = currentThread().getContextClassLoader().getResource("help.txt");
            if (Objects.nonNull(resource)) {
                helpMessage = Files.readAllLines(Paths.get(resource.toURI()));
            } else {
                helpMessage = HELP_CURRENTLY_UNAVAILABLE_MESSAGE;
            }
        } catch (IOException | URISyntaxException e) {
            helpMessage = HELP_CURRENTLY_UNAVAILABLE_MESSAGE;
        }

        helpMessage.forEach(out::println);
        final View<PostHelpAction> postHelpActionMenu =
                new ConsoleMenu<>("", "Please put operation number", PostHelpAction.values());
        final PostHelpAction postHelpAction = postHelpActionMenu.readUserChoice();
        if (postHelpAction == PostHelpAction.RETURN) {
            Launcher.launchGame();
        } else {
            GameUtil.exitGame();
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
