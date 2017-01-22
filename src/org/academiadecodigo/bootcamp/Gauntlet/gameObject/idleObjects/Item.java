package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.test.Game;

import static org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType.END;
import static org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType.HEALTH;
import static org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType.POISON;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Item extends GameObject {
    // TODO => GIULIANO !
    ItemType itemType;                  // Defines what behaviour the item will have
    int value;                          // Value


    public int getValue(ItemType itemType) {

        switch (itemType){
            case HEALTH:
                return value = HEALTH.getValue();
            case POISON:
                return value = POISON.getValue();
            case END:
                Game.endGame();
                return 0;
        }

        // What happens when Player collects item
        return value;
    }
}
