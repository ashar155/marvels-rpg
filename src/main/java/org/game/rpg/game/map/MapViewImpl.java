package org.game.rpg.game.map;

import org.game.rpg.inventory.characterInventory.Character;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.generate;

public class MapViewImpl<T extends Character> implements MapView<T> {

    private static final String PIPE = "|";
    private static final String NEWLINE = "\n";
    private static final char BAR = '-';
    private static final int BACKWARD = -1;
    private static final int FORWARD = 1;
    private static final int MAP_SIZE_MARGIN = 2;
    private static final String CAN_T_MOVE_MESSAGE = "You can't go to %s, face your enemy!";

    private List<String> entityTitles;
    private static int gridSize;
    private char[][] grid;
    private List<T> entities;

    public MapViewImpl(List<T> entities) {
        this.entities = entities;
        this.entityTitles = entities.stream().map(e -> e.getName()).collect(Collectors.toList());
        this.gridSize = entities.size();
        this.grid = new char[gridSize][gridSize];
        initGrid();
    }

    private void initGrid() {
        entities.forEach(this::updatePosition);
    }

    private void updatePosition(T entity) {
        grid[(int) entity.position().getX()][(int) entity.position().getY()] = entity.getName().charAt(0);
    }

    @Override
    public void viewMap() {
        printHLine();
        for (int i = 0; i < gridSize; i++) {
            System.out.print(PIPE);
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.print(PIPE + NEWLINE);
        }
        printHLine();
    }

    private void printHLine() {
        System.out.println(
                generate(() -> "-").limit(entities.size() + MAP_SIZE_MARGIN).collect(joining())
        );
    }

    @Override
    public void updateUserPosition(Direction direction) {
        entities.stream()
                .filter(entity -> entity.getName().charAt(0) == 'U')
                .findFirst()
                .ifPresent(entity -> move(entity, direction));
        viewMap();
    }

    private void move(T userEntity, Direction direction) {
        switch (direction) {
            case RIGHT:
                moveRight(userEntity);
                break;
            case LEFT:
                moveLeft(userEntity);
                break;
            case UP:
                moveUp(userEntity);
                break;
            case DOWN:
                moveDown(userEntity);
                break;
            default:
        }
    }

    private void moveLeft(T userEntity) {
        if (canMoveLeft(userEntity)) {
            System.out.println("Moving left from " + userEntity.position());
            moveHorizontally(userEntity, BACKWARD);
        } else {
            System.out.println(String.format(CAN_T_MOVE_MESSAGE, "LEFT"));
        }
    }


    private void moveRight(T userEntity) {
        if (canMoveRight(userEntity)) {
            System.out.println("Moving right from " + userEntity.position());
            moveHorizontally(userEntity, FORWARD);
        } else {
            System.out.println(String.format(CAN_T_MOVE_MESSAGE, "RIGHT"));
        }
    }

    private void moveUp(T userEntity) {
        if (canMoveUp(userEntity)) {
            System.out.println("Moving up from " + userEntity.position());
            moveVertically(userEntity, BACKWARD);
        } else {
            System.out.println(String.format(CAN_T_MOVE_MESSAGE, "UP"));
        }
    }

    private void moveDown(T userEntity) {
        if (canMoveDown(userEntity)) {
            System.out.println("Moving down from " + userEntity.position());
            moveVertically(userEntity, FORWARD);
        } else {
            System.out.println(String.format(CAN_T_MOVE_MESSAGE, "DOWN"));
        }
    }

    private boolean canMoveLeft(T userEntity) {
        return ((int) userEntity.position().getY()) > 0;
    }

    private boolean canMoveRight(T userEntity) {
        return ((int) userEntity.position().getY()) < gridSize;
    }

    private boolean canMoveUp(T userEntity) {
        return ((int) userEntity.position().getX()) > 0;
    }

    private boolean canMoveDown(T userEntity) {
        return ((int) userEntity.position().getX()) < gridSize;
    }

    private void moveHorizontally(T userEntity, int distance) {
        grid[(int) userEntity.position().getX()][(int) userEntity.position().getY()] = '\u0000';
        userEntity.setPosition(new Point((int) userEntity.position().getX(), (int) userEntity.position().getY() + distance));
        grid[(int) userEntity.position().getX()][(int) userEntity.position().getY()] = userEntity.getName().charAt(0);
        System.out.printf("Moved to (%s, %s)\n", userEntity.position().getX(), userEntity.position().getY());
    }

    private void moveVertically(T userEntity, int distance) {
        grid[(int) userEntity.position().getX()][(int) userEntity.position().getY()] = '\u0000';
        userEntity.setPosition(new Point((int) userEntity.position().getX() + distance, (int) userEntity.position().getY()));
        grid[(int) userEntity.position().getX()][(int) userEntity.position().getY()] = userEntity.getName().charAt(0);
        System.out.printf("Moved to (%s, %s)\n", userEntity.position().getX(), userEntity.position().getY());
    }
}
