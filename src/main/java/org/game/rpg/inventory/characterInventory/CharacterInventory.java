package org.game.rpg.inventory.characterInventory;

import org.game.rpg.inventory.characterInventory.hero.*;
import org.game.rpg.inventory.characterInventory.villain.*;

import java.awt.*;

public class CharacterInventory {
    private CharacterInventory() {
    }

    public static Hero getHero(HeroType type, Point position) {
        switch (type) {
            case SPIDERMAN:
                return new Spiderman(position);
            case HULK:
                return new Hulk(position);
            case BATMAN:
                return new Batman(position);
            case IROMMAN:
                return new Ironman(position);
            case THOR:
                return new Thor(position);
            default:
                throw new UnsupportedOperationException("Not a valid character type");
        }
    }

    public static Villain getVillain(VillainType type, Point position) {
        switch (type) {
            case DOCTORDOOM:
                return new DoctorDoom(position);
            case MAGNETO:
                return new Magneto(position);
            case REDSKULL:
                return new RedSkull(position);
            case LOKI:
                return new Loki(position);
            case THANOS:
                return new Thanos(position);
            default:
                throw new UnsupportedOperationException("Not a valid character type");
        }
    }
}
