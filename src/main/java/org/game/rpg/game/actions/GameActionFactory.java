package org.game.rpg.game.actions;

import org.game.rpg.game.actions.help.GameHelp;
import org.game.rpg.game.actions.resume.ResumeGame;
import org.game.rpg.game.actions.save.SaveGame;
import org.game.rpg.game.actions.start.StartGame;

public class GameActionFactory {

    private GameActionFactory() {
    }

    public static GameAction launch(Action mode) {
        switch (mode) {
            case START:
                return new StartGame();
            case RESUME:
                return new ResumeGame();
            case HELP:
                return new GameHelp();
            case SAVE:
                return new SaveGame();
            case STORY:
                throw new UnsupportedOperationException("Story mode is not present in this version");
            default:
                throw new UnsupportedOperationException("Mode is not valid");
        }
    }
}
