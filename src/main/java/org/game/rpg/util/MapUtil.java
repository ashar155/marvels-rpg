package org.game.rpg.util;

import java.awt.*;
import java.util.Random;

public class MapUtil {

    private static char[] [] grid;
    private static int gridSize;

    public static Point getRandomPoint(Random random, char[] [] grid, int gridSize) {
        final Point point = new Point(random.nextInt(gridSize), random.nextInt(gridSize));
        if (positionTaken(point, grid)) {
            return getRandomPoint(random, grid, gridSize);
        }
        return point;
    }

    private static boolean positionTaken(Point point, char[] [] grid) {
        return grid[(int) point.getX()][(int) point.getY()] != '\u0000';
    }
}
