package org.game.rpg.util;

import static java.lang.System.exit;
import static java.lang.System.out;

public class GameUtil {

    private GameUtil() {
    }

    public static void gameOver() {
        out.println("Game Over");
        exit(1);
    }
}
