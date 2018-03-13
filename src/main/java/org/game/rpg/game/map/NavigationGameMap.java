package org.game.rpg.game.map;

import org.game.rpg.inventory.characterInventory.Character;
import org.game.rpg.inventory.characterInventory.CharacterInventory;
import org.game.rpg.inventory.characterInventory.hero.Hero;
import org.game.rpg.inventory.characterInventory.villain.Villain;
import org.game.rpg.inventory.characterInventory.villain.VillainType;
import org.game.rpg.inventory.weapons.Weapon;
import org.game.rpg.util.FightUtil;
import org.game.rpg.util.GameUtil;
import org.game.rpg.util.MapUtil;
import org.game.rpg.view.View;
import org.game.rpg.view.console.ConsoleMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.System.out;
import static java.util.Objects.isNull;

public class NavigationGameMap implements GameMap {
    private static List<Character> entityList;
    private Hero userCharacter;
    private Villain enemy;
    private MapViewImpl<Character> characterMapView;

    public NavigationGameMap(Hero hero) {
        if (isNull(entityList)) {
            this.entityList = new ArrayList<>();
        }
        this.userCharacter = hero;
        initializeEntityList();
        characterMapView = new MapViewImpl<>(entityList);
    }

    private void initializeEntityList() {
        entityList.add(userCharacter);
        entityList.add(getRandomVillain());
        entityList.add(getRandomVillain());
        entityList.add(getRandomVillain());
        entityList.add(getRandomVillain());
        entityList.add(getRandomVillain());
    }

    private Villain getRandomVillain() {
        final VillainType villainType = VillainType.chooseRandom();
        Optional<Character> any = entityList.stream().filter(e -> e.getName().equals(villainType.getName())).findAny();
        if (any.isPresent()) {
            return getRandomVillain();
        }
        return CharacterInventory.getVillain(villainType, MapUtil.getRandomPoint(new Random()));
    }

    @Override
    public void moveUser(Direction direction) {
        characterMapView.updateUserPosition(direction);
    }

    private void fight(Villain enemy) {
        final View<Weapon> weaponMenu = new ConsoleMenu<>("Choose Weapon to fight", "Please put operation number to select weapon", userCharacter.getWeaponList());
        Weapon userWeapon = weaponMenu.readUserChoice();
        userCharacter.setWeapon(userWeapon);
        FightUtil.attack(userCharacter, enemy);
        if (userCharacter.health() <= 0) {
            GameUtil.gameOver();
        }

        if (enemy.health() <= 0) {
            enemyDied(enemy);
            return;
        }
        fight(enemy);
    }

    private void enemyDied(Villain villain) {
        entityList.remove(villain);
        out.println("Enemy died");
    }

    private boolean checkEnemy() {
        return true;
    }

    @Override
    public boolean enemyRemaining() {
        return entityList.size() == 1;
    }
}
