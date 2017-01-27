package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.movableObjects.Player;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;
import org.academiadecodigo.bootcamp.Gauntlet.test.Game;

import static org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType.POTION;
import static org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects.ItemType.POISON;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Item extends GameObject {
    // TODO => GIULIANO !
    ItemType itemType;                  // Defines what behaviour the item will have
    int value;                          // Value

    public Item(Grid grid, GridPosition position) {  //CORRECTED CONSTRUCTOR
        super(grid, position, GameObjType.ITEM); //TODO: We'll have to create subclasses here. Update constructor to fix type.

    }

    public int collectItem(ItemType itemType, Player player) {

        switch (itemType){
            case POTION:
                return value = POTION.getValue();
            case POISON:
                return value = POISON.getValue();
            case PRINCESS:

                return 0;
            case EXIT:
                //ITEM CANT HAVE A PROPERTY Game AND Game.endGame() CANT BE STATIC
                //SUGGESTION: ACTION DETECTOR CHOOSES ACTION WHEN PLAYER COLLECTS THIS ITEM TODO: Create this method
                return 0;
            default:
                System.out.println("Something went terribly wrong");
        }

        // What happens when Player collects item
        return value;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
