package org.academiadecodigo.bootcamp.Gauntlet.gameObject.idleObjects;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObjType;
import org.academiadecodigo.bootcamp.Gauntlet.gameObject.GameObject;
import org.academiadecodigo.bootcamp.Gauntlet.grid.Grid;
import org.academiadecodigo.bootcamp.Gauntlet.grid.position.GridPosition;

/**
 * Created by s7r1d3r on 20-01-2017.
 */
public class Item extends GameObject {
    // TODO => GIULIANO !
    ItemType itemType;                  // Defines what behaviour the item will have
    private static int value;                          // Value

    public Item(Grid grid, GridPosition position) {  //CORRECTED CONSTRUCTOR
        super(grid, position, GameObjType.ITEM); //TODO: We'll have to create subclasses here. Update constructor to fix type.

    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType){
        this.itemType = itemType;
    }

}
