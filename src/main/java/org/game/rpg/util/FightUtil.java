package org.game.rpg.util;

import org.game.rpg.inventory.characterInventory.hero.Hero;
import org.game.rpg.inventory.characterInventory.villain.Villain;
import org.game.rpg.inventory.weapons.Weapon;

import static java.lang.System.out;

public class FightUtil {
    public static void attack(final Hero hero, final Villain villain) {
        final Weapon enemyWeapon = villain.selectRandomWeapon();
        final int enemyDamage = hero.getWeapon().getAttackPower() - enemyWeapon.getDefencePower();
        final int heroDamage = enemyWeapon.getAttackPower() - hero.getWeapon().getDefencePower();
        hero.decreaseHealth(heroDamage > 0 ? heroDamage : 0);
        villain.decreaseHealth(enemyDamage > 0 ? enemyDamage : 0);
        out.println();
        out.printf("Hero -> Name: %s, Weapon: %s, Heath: %s", hero.getName(), hero.getWeapon(), hero.health());
        out.println();
        out.printf("Enemy -> Name: %s, Weapon: %s, Heath: %s", villain.getName(), enemyWeapon, villain.health());
        out.println();
    }
}
