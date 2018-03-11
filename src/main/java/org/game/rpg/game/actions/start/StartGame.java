package org.game.rpg.game.actions.start;

import org.game.rpg.game.actions.GameAction;
import org.game.rpg.game.map.Direction;
import org.game.rpg.game.map.NavigationMap;
import org.game.rpg.inventory.characterInventory.CharacterInventory;
import org.game.rpg.inventory.characterInventory.hero.Hero;
import org.game.rpg.inventory.characterInventory.hero.HeroType;
import org.game.rpg.view.console.Menu;

public class StartGame implements GameAction {
    @Override
    public void action() {
        final HeroType heroType = createCharacter();
        final Hero userCharacter = CharacterInventory.getHero(heroType);
        traverseThroughMap(userCharacter);
    }

    private void traverseThroughMap(Hero userCharacter) {
        NavigationMap traverse = new NavigationMap(userCharacter);
        do {
            Menu<Direction> directionMenu = new Menu<>("Explore", "Please enter operation number", Direction.values());
            Direction direction = directionMenu.readUserChoice();
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
        Menu<HeroType> heroTypeMenu = new Menu<>("Choose Character", "Please enter operation number", HeroType.values());
        return heroTypeMenu.readUserChoice();
    }
}
