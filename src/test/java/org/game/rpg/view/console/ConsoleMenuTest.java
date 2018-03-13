package org.game.rpg.view.console;

import org.game.rpg.game.actions.Action;
import org.game.rpg.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleMenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void readUserChoiceForStart() {
        final View<Action> view = new ConsoleMenu<>(Action.TITLE, Action.FOOTER_MESSAGE, Action.values());
        final InputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        final Action outputAction = view.readUserChoice();
        assertThat(outputAction).isEqualTo(Action.START);
    }

    @Test
    public void readUserChoiceForResume() {
        final View<Action> view = new ConsoleMenu<>(Action.TITLE, Action.FOOTER_MESSAGE, Action.values());
        final InputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        final Action outputAction = view.readUserChoice();
        assertThat(outputAction).isEqualTo(Action.RESUME);
        /*assertTrue(outContent.toString().contains(Action.START.name()));
        assertTrue(outContent.toString().contains(Action.HELP.name()));
        assertTrue(outContent.toString().contains(Action.RESUME.name()));*/
    }
}