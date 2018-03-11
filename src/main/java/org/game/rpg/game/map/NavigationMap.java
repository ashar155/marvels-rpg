package org.game.rpg.game.map;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.CharacterInventory;
import org.game.rpg.inventory.characterInventory.hero.Hero;
import org.game.rpg.inventory.characterInventory.villain.Villain;
import org.game.rpg.inventory.characterInventory.villain.VillainType;
import org.game.rpg.inventory.weapons.Weapon;
import org.game.rpg.util.FightUtil;
import org.game.rpg.util.GameUtil;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

import java.util.HashMap;

import static java.lang.System.out;
import static java.util.Objects.isNull;

public class NavigationMap implements Map {
    private static java.util.Map<Character, Coordinates> initialMap;
    private Hero userCharacter;
    private Villain enemy;

    public NavigationMap(Hero hero) {
        synchronized (this) {
            if (isNull(initialMap)) {
                this.initialMap = new HashMap<>();
            }
            this.userCharacter = hero;
            initialMap.put(userCharacter, new Coordinates(0, 0));
        }
    }

    @Override
    public void goRight() {
        initialMap.get(userCharacter).incrementX();
        final boolean enemyPresent = checkEnemy();
        if(enemyPresent) {
            final Villain enemy = getEnemy();
            fight(enemy);
        }
    }

    @Override
    public void goLeft() {
        initialMap.get(userCharacter).decrementX();
        final boolean enemyPresent = checkEnemy();
        if(enemyPresent) {
            final Villain enemy = getEnemy();
            fight(enemy);
        }
    }

    @Override
    public void goUp() {
        initialMap.get(userCharacter).incrementY();
        final boolean enemyPresent = checkEnemy();
        if(enemyPresent) {
            final Villain enemy = getEnemy();
            fight(enemy);
        }
    }

    @Override
    public void goDown() {
        initialMap.get(userCharacter).decrementY();
        final boolean enemyPresent = checkEnemy();
        if(enemyPresent) {
            final Villain enemy = getEnemy();
            fight(enemy);
        }
    }

    private void fight(Villain enemy) {
        final View<Weapon> weaponMenu = new ConsoleMenu<>("Choose Weapon to fight", "Please put operation number to select weapon", userCharacter.getWeaponList());
        Weapon userWeapon = weaponMenu.readUserChoice();
        userCharacter.setWeapon(userWeapon);
        FightUtil.attack(userCharacter, enemy);
        if(userCharacter.health() <= 0) {
            GameUtil.gameOver();
        }

        if(enemy.health() <= 0) {
            enemyDied(enemy);
            return;
        }
        fight(enemy);
    }

    private void enemyDied(Villain villain) {
        initialMap.remove(villain);
        out.println("Enemy died");
    }

    private boolean checkEnemy() {
        return true;
    }

    @Override
    public boolean enemyRemaining() {
        return initialMap.size() == 1;
    }

    VillainType villainType = VillainType.chooseRandom();

    public Villain getEnemy() {
        return CharacterInventory.getVillain(villainType);
    }
}
