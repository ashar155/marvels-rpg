package org.game.rpg.game.actions;

import org.assertj.core.api.Assertions;
import org.game.rpg.game.actions.help.GameHelp;
import org.game.rpg.game.actions.start.StartGame;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameActionFactoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getGameAction_ForStart_AndExpectInstanceOfStartGame() {
        final GameAction gameAction = GameActionFactory.getGameAction(Action.START);
        Assertions.assertThat(gameAction).isInstanceOf(StartGame.class);
    }

    @Test
    public void getGameAction_ForHelp_AndExpectInstanceOfGameHelp() {
        final GameAction gameAction = GameActionFactory.getGameAction(Action.HELP);
        Assertions.assertThat(gameAction).isInstanceOf(GameHelp.class);
    }

    @Test
    public void getGameAction_ForResume_AndExpectInstanceOfResumeGame() {
        final GameAction gameAction = GameActionFactory.getGameAction(Action.HELP);
        Assertions.assertThat(gameAction).isInstanceOf(GameHelp.class);
    }

    @Test
    public void getGameAction_ForStory_AndExpectUnsupportedOperationException() {
        expectedException.expect(UnsupportedOperationException.class);
        GameActionFactory.getGameAction(Action.STORY);
    }
}