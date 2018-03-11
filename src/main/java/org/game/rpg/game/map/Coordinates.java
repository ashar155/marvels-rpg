package org.game.rpg.game.map;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        this.x += 1;
    }

    public void decrementX() {
        if(this.x == 0) {
            return;
        }
        this.x -= 1;
    }

    public void incrementY() {
        this.y += 1;
    }

    public void decrementY() {
        if(this.x == 0) {
            return;
        }
        this.y -= 1;
    }
}
