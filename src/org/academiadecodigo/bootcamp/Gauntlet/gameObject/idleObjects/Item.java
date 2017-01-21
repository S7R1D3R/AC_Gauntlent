package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Item extends GameObject {
    // TODO => GIULIANO !
    ItemType itemType;                  // Defines what behaviour the item will have
    int value;                          // Value


    public int getValue() {


        // What happens when Player collects item
        return value;
    }
}
