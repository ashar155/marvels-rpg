package org.game.rpg.game.actions.start;

import org.game.rpg.game.actions.GameAction;
import org.game.rpg.game.map.Direction;
import org.game.rpg.game.map.NavigationMap;
import org.game.rpg.inventory.characterInventory.CharacterInventory;
import org.game.rpg.inventory.characterInventory.hero.Hero;
import org.game.rpg.inventory.characterInventory.hero.HeroType;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

public class StartGame implements GameAction {
    @Override
    public void action() {
        final HeroType heroType = createCharacter();
        final Hero userCharacter = CharacterInventory.getHero(heroType);
        traverseThroughMap(userCharacter);
    }

    private void traverseThroughMap(Hero userCharacter) {
        final NavigationMap traverse = new NavigationMap(userCharacter);
        do {
            final View<Direction> directionMenu = new ConsoleMenu<>(Direction.TITLE, Direction.FOOTER_MESSAGE, Direction.values());
            final Direction direction = directionMenu.readUserChoice();
            switch (direction) {
                case UP:
                    traverse.goUp();
                case DOWN:
                    traverse.goDown();
                case LEFT:
                    traverse.goLeft();
                case RIGHT:
                    traverse.goRight();
            }
        } while (!traverse.enemyRemaining() && userCharacter.health() > 0);
        endGameGreetings();
    }

    private void endGameGreetings() {
        System.out.println("Game Over");
    }

    private HeroType createCharacter() {
        final View<HeroType> heroTypeMenu = new ConsoleMenu<>(HeroType.TITLE, HeroType.FOOTER_MESSAGE, HeroType.values());
        return heroTypeMenu.readUserChoice();
    }
}
